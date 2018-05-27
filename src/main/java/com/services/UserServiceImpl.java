package com.services;

import com.classes.Priority;
import com.classes.Task;
import com.classes.TemplateTask;
import com.classes.User;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {

    public User createUser(String name) {
        return new User(name);
    }

    public void assignSingleTask(User assignee, User assigned, Task t) {
        t.setAssigned(assigned);
        t.setAssignee(assignee);
        assigned.addAssigned(t);
        assignee.addWatching(t);
    }

    public void deassignSingleTask(User assignee, User assigned, Task t) {
        t.setAssigned(null);
        assigned.removeAssigned(t);
    }

    public void assignRecurringTask(Task t) {
        t.getAssigned().addAssigned(t);
        t.getAssignee().addWatching(t);
    }

    public void assignTaskUsingTemplate(User assignee, User assigned, String taskName, Priority priority) {
        Task task = assignee.getFromTemplate(taskName);
        task.setAssigned(assigned);
        task.setAssignee(assignee);
        assigned.addAssigned(task);
        assignee.addAssigned(task);
    }

    public void createNewTemplate(User assignee, String taskname, Task t) {
        assignee.addTemplate(taskname,t);
    }

    public List<Task> viewAssignedTasks(User assigned) {
        return Collections.unmodifiableList(assigned.getAssigned());
    }

    public List<Task> viewWatchingTasks(User assignee) {
        return Collections.unmodifiableList(assignee.getWatching());
    }

    public Map<String, TemplateTask> viewTaskTemplates(User assignee) {
        return Collections.unmodifiableMap(assignee.getTemplates());
    }
}