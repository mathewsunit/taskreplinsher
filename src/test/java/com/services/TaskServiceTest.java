package com.services;

import com.classes.*;
import org.junit.Test;

public class TaskServiceTest {

    @Test
    public void changeTaskPriority() {
        TaskService taskService = TaskServiceImpl.getInstance();
        Task test = new Task("Test");
        taskService.changeTaskPriority(test, 0);
        assert test.getPriority() == Priority.LOW;
        taskService.changeTaskPriority(test, 3);
        assert test.getPriority() == Priority.CRITICAL;
    }

    @Test
    public void createNewTask() {
        TaskService taskService = TaskServiceImpl.getInstance();
        Task test = new Task("Test");
        assert test != null;
    }

    @Test
    public void createNewRecurringTask() {
        TaskService taskService = TaskServiceImpl.getInstance();
        RecurringTask test = taskService.createNewRecurringTask("test", new User("Assigned"), new User("Assignee"), 5);
        assert test != null;
    }

    @Test
    public void createNewTemplateTask() {
        TaskService taskService = TaskServiceImpl.getInstance();
        TemplateTask test = taskService.createNewTemplateTask("test");
        assert test != null;
    }

    @Test
    public void beginTask() {
        TaskService taskService = TaskServiceImpl.getInstance();
        Task test = taskService.createNewTask("test");
        taskService.beginTask(test);
        assert test.getStatus() == Status.STARTED;
        assert test.getBegin() != null;
    }

    @Test
    public void endTask() {
        TaskService taskService = TaskServiceImpl.getInstance();
        Task test = taskService.createNewTask("test");
        taskService.beginTask(test);
        taskService.endTask(test);
        assert test.getStatus() == Status.COMPLETED;
        assert test.getEnd() != null;
    }

    @Test
    public void deleteTask() {
        TaskService taskService = TaskServiceImpl.getInstance();
        Task test = taskService.createNewTask("test");
        UserService userService = UserServiceImpl.getInstance();
        User assignee = userService.createUser("Assignee");
        User assigned = userService.createUser("Assigned");
        userService.assignSingleTask(assignee, assigned, test);
        taskService.deleteTask(test);
        assert test.getAssignee() == null;
        assert test.getAssigned() == null;
        assert assignee.getWatching().size() == 0;
        assert assigned.getAssigned().size() == 0;
    }
}