package com.services;

import com.classes.*;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class UserServiceTest {

    @Test
    public void createUser() {
        UserService userService = UserServiceImpl.getInstance();
        User user = userService.createUser("Test");
        assert user.getName().equals("Test");
    }

    @Test
    public void assignSingleTask() {
        UserService userService = UserServiceImpl.getInstance();
        User assigned = userService.createUser("Assigned");
        User assignee = userService.createUser("Assignee");
        userService.assignSingleTask(assignee, assigned, new Task("Task"));
        assert assignee.getWatching().size() == 1;
        assert assigned.getAssigned().size() == 1;
    }

    @Test
    public void deassignSingleTask() {
        UserService userService = UserServiceImpl.getInstance();
        User assigned = userService.createUser("Assigned");
        User assignee = userService.createUser("Assignee");
        Task task = new Task("Task");
        userService.assignSingleTask(assignee, assigned, task);
        userService.deassignSingleTask(assignee, assigned, task);
        assert assignee.getWatching().size() == 1;
        assert assigned.getAssigned().size() == 0;
    }

    @Test
    public void assignRecurringTask() {
        UserService userService = UserServiceImpl.getInstance();
        User assigned = userService.createUser("Assigned");
        User assignee = userService.createUser("Assignee");
        RecurringTask recurringTask = new RecurringTask(new Task("Task"), assigned, assignee, 5);
        userService.assignRecurringTask(recurringTask.getInstance());
        assert assignee.getWatching().size() == 1;
        assert assigned.getAssigned().size() == 1;
        userService.assignRecurringTask(recurringTask.getInstance());
        assert assignee.getWatching().size() == 2;
        assert assigned.getAssigned().size() == 2;
    }

    @Test
    public void assignTaskUsingTemplate() {
        UserService userService = UserServiceImpl.getInstance();
        User assigned = userService.createUser("Assigned");
        User assignee = userService.createUser("Assignee");
        userService.createNewTemplate(assignee, "Test", new Task("Task"));
        userService.assignTaskUsingTemplate(assignee, assigned, "Test", Priority.CRITICAL);
        assert assignee.getWatching().size() == 1;
        assert assigned.getAssigned().size() == 1;
        assert assignee.getWatching().get(0).getPriority() == Priority.CRITICAL;
    }

    @Test
    public void createNewTemplate() {
        UserService userService = UserServiceImpl.getInstance();
        User assignee = userService.createUser("Assignee");
        userService.createNewTemplate(assignee, "Test", new Task("Task"));
        Map<String, TemplateTask> map = assignee.getTemplates();
        assert map.size() == 1;
        assert map.get("Test") != null;
    }

    @Test
    public void recurringTaskRunner() {
        UserService userService = UserServiceImpl.getInstance();
        User assigned = userService.createUser("Assigned");
        User assignee = userService.createUser("Assignee");
        RecurringTask recurringTask = new RecurringTask(new Task("Task"), assigned, assignee, 5);
        RecurringTaskRunnerService recurringTaskRunnerService = new RecurringTaskRunnerService(recurringTask, userService);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(recurringTaskRunnerService, 0, recurringTask.getFrequency(), TimeUnit.SECONDS);

        try {
            TimeUnit.MILLISECONDS.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executor.shutdown();
        assert assigned.getAssigned().size() > 3;
        assert assignee.getWatching().size() > 3;
    }
}