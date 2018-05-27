package com.services;

import com.classes.RecurringTask;

public class RecurringTaskRunner implements Runnable{
    RecurringTask task;
    UserServicesImpl userServices;

    public RecurringTaskRunner(RecurringTask task, UserServicesImpl userServices) {
        this.task = task;
        this.userServices = userServices;
    }

    public void run() {
        userServices.assignRecurringTask(task.getInstance());
    }
}
