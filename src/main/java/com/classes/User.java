package com.classes;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class User {

    String name;
    List<Task> watching;
    List<Task> assigned;
    HashMap<String,TemplateTask> templates;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getWatching() {
        return watching;
    }

    public void setWatching(List<Task> watching) {
        this.watching = watching;
    }

    public void addWatching(Task task) { this.watching.add(task); }

    public void addAssigned(Task task) { this.assigned.add(task); }

    public void removeAssigned(Task task) { this.assigned.remove(task); }

    public void removeWatching(Task task) { this.watching.remove(task); }

    public List<Task> getAssigned() {
        return assigned;
    }

    public void setAssigned(List<Task> assigned) {
        this.assigned = assigned;
    }

    public void addTemplate(String name, Task t) {
        templates.put(name,new TemplateTask(t));
    }

    public Task getFromTemplate(String name) {
        return templates.get(name).getInstance();
    }

    public HashMap<String,TemplateTask> getTemplates()  {
        return templates;
    }

    public User(String name) {
        this.name = name;
        watching = new LinkedList<Task>();
        assigned = new LinkedList<Task>();
        templates = new HashMap<String, TemplateTask>();
    }

}
