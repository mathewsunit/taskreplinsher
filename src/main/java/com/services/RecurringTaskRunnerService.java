package com.services;

import com.classes.RecurringTask;

public class RecurringTaskRunnerService implements Runnable{
    RecurringTask task;
    UserServiceImpl userServices;

    public RecurringTaskRunnerService(RecurringTask task, UserServiceImpl userServices) {
        this.task = task;
        this.userServices = userServices;
    }

    public void run() {
        userServices.assignRecurringTask(task.getInstance());
    }
}
