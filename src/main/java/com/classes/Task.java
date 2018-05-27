package com.classes;

import java.util.Date;

public class Task implements Taskable, Comparable<Task> {

    User assigned;
    User assignee;
    Status status;
    Priority priority;
    String notes;
    String feedback;
    long timeEstimate;
    Date begin;
    Date end;


    public User getAssigned() {
        return assigned;
    }

    public void setAssigned(User assigned) {
        this.assigned = assigned;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public long getTimeEstimate() {
        return timeEstimate;
    }

    public void setTimeEstimate(Long timeEstimate) {
        this.timeEstimate = timeEstimate;
    }

    public long getTimeElapsed(Date date) {
        return getBegin().getTime()- date.getTime();
    }

    public Date getBegin() {
        return begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Task(User user, Date date) {
        this.assignee = user;
        this.begin = date;
    }

    public Task(Task task) {
        this.setAssignee(task.getAssignee());
        this.setAssigned(task.getAssigned());
        this.setTimeEstimate(task.getTimeEstimate());
        this.setPriority(task.getPriority());
        this.begin = new Date();
    }

    public Status getStatus() {
        return status;
    }

    public void changeStatus(Status status) {
        this.status = status;
    }

    public String getNotes() {
        return notes.toString();
    }

    public String getFeedback() {
        return feedback;
    }

    public void appendNotes(String append) {
        notes.concat(append) ;
    }

    public void setFeedback(String feedback) {
        notes.concat("\n******Changing Feedback******\n"+this.feedback);
        this.feedback = feedback;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority p) {
        this.priority = p;
    }

    public int compareTo(Task task) {
        return 0;
    }

    public void start(Date begin) {
        this.begin = begin;
    }

    public void finish(Date end) {
        this.status = Status.COMPLETED;
        this.end = end;
    }
}