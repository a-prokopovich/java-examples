package com.prokopovich.patterns.visitor;

import java.util.ArrayList;

public class Task implements ProjectItem {
    private String taskCode;
    private double rimeRequired;
    private ArrayList projectItems = new ArrayList();

    public Task(String taskCode, double rimeRequired) {
        this.taskCode = taskCode;
        this.rimeRequired = rimeRequired;
    }

    public double getRimeRequired() {
        return rimeRequired;
    }

    public void addProjectItem(ProjectItem element) {
        projectItems.add(element);
    }

    @Override
    public void accept(ProjectVisitor visitor) {
        visitor.visitTask(this);
    }

    @Override
    public ArrayList getProjectItems() {
        return projectItems;
    }
}