package com.classes;

public class RecurringTask extends CustomTask {

    boolean enabled;
    long frequency;

    public RecurringTask(Task task, long frequency) {
        super(task);
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
