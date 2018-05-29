package com.classes;

import java.util.Date;

public interface Taskable {

    public User getAssigned();

    public void setAssigned(User assigned);

    public User getAssignee();

    public void setAssignee(User assignee);

    public Status getStatus();

    public void changeStatus(Status status);

    public String getNotes();

    public String getFeedback();

    public void setFeedback(String feedback);

    public void appendNotes(String append);

    public Priority getPriority();

    public void setPriority(Priority p);

    public long getTimeEstimate();

    public void setTimeEstimate(Long timeEstimate);

    public long getTimeElapsed(Date date);

    public Date getEnd();

    public void setEnd(Date end);

    public Date getBegin();

    public void start(Date begin);

    public void finish(Date end);
}