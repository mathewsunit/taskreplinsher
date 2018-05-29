package com.classes;

public class RecurringTask extends CustomTask {

    boolean enabled;
    long frequency;

    public RecurringTask(Task task, User assigned, User assignee, long frequency) {
        super(task);
        super.setAssigned(assigned);
        super.setAssignee(assignee);
        this.frequency = frequency;
    }

    public void start() {
        enabled = true;
    }

    public long getFrequency() {
        return frequency;
    }

    public void setFrequency(long frequency) {
        this.frequency = frequency;
    }

    public Task getInstance() {
        return new Task(super.task);
    }
}
