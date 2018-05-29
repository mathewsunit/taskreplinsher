package com.classes;

import java.util.Date;

public class Task implements Taskable, Comparable<Task> {

    String name;
    User assigned;
    User assignee;
    Status status;
    Priority priority;
    String notes;
    String feedback;
    long timeEstimate;
    Date begin;
    Date end;


    public Task(String name) {
        this.name = name;
    }

    public Task(Task task) {
        this.name = task.name;
        this.assignee = task.getAssignee();
        this.assigned = task.getAssigned();
        this.timeEstimate = task.getTimeEstimate();
        this.priority = task.getPriority();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
        return getBegin().getTime() - date.getTime();
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

    public void begin() {
        this.begin = new Date();
        this.status = Status.STARTED;
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

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public void appendNotes(String append) {
        notes.concat(append);
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