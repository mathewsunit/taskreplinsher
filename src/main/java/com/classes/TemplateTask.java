package com.classes;

public class TemplateTask extends CustomTask {

    public TemplateTask(Task task) {
        super(task);
    }

    public Task getInstance() {
        return new Task(super.task);
    }
}
