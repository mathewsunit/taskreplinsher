package com.services;

import com.classes.*;

import java.util.List;
import java.util.Map;

public interface UserServices {

    public User createUser(String name);

    public void assignSingleTask(User assignee, User assigned, Task t);

    public void deassignSingleTask(User assignee, User assigned, Task t);

    public void assignRecurringTask(Task t);

    public void assignTaskUsingTemplate(User assignee, User assigned, String taskName, Priority priority);

    public void createNewTemplate(User assignee, String taskname, Task t);

    public List<Task> viewAssignedTasks(User assignee);

    public List<Task> viewWatchingTasks(User assignee);

    public Map<String, TemplateTask> viewTaskTemplates(User assignee);

}
