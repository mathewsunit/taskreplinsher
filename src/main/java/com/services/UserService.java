package com.services;

import com.classes.Priority;
import com.classes.Task;
import com.classes.User;

import java.util.List;

public interface UserService {

    public User createUser(String name);

    public void assignSingleTask(User assignee, User assigned, Task t);

    public void deassignSingleTask(User assignee, User assigned, Task t);

    public void assignRecurringTask(Task t);

    public void assignTaskUsingTemplate(User assignee, User assigned, String taskName, Priority priority);

    public void createNewTemplate(User assignee, String taskname, Task t);

}
