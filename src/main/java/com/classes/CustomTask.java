package com.classes;

import java.util.Date;

public class CustomTask implements Taskable {

    protected Task task;

    public CustomTask(Task task) {
        this.task = task;
    }

    public User getAssigned() {
        return task.getAssigned();
    }

    public void setAssigned(User assigned) {
        task.setAssigned(assigned);
    }

    public User getAssignee() {
        return task.getAssignee();
    }

    public void setAssignee(User assignee) {
        task.setAssignee(assignee);
    }

    public Status getStatus() {
        return task.getStatus();
    }

    public void changeStatus(Status status) {
        task.changeStatus(status);
    }

    public String getNotes() {
        return task.getNotes();
    }

    public String getFeedback() {
        return task.getFeedback();
    }

    public void appendNotes(String append) {
        task.appendNotes(append);
    }

    public void setFeedback(String feedback) {
        task.setFeedback(feedback);
    }

    public Priority getPriority() {
        return task.getPriority();
    }

    public void setPriority(Priority p) {
        task.setPriority(p);
    }

    public long getTimeEstimate() {
        return task.getTimeEstimate();
    }

    public void setTimeEstimate(Long timeEstimate) {
        task.setTimeEstimate(timeEstimate);
    }

    public long getTimeElapsed(Date date) {
        return task.getTimeElapsed(date);
    }

    public Date getEnd() {
        return task.getEnd();
    }

    public Date getBegin() {
        return task.getBegin();
    }

    public void setEnd(Date end) {
        task.setEnd(end);
    }

    public void start(Date begin) {
        task.start(begin);
    }

    public void finish(Date end) {
        task.setEnd(end);
    }
}
