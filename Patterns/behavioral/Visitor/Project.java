package com.prokopovich.patterns.visitor;

import java.util.ArrayList;

public class Project implements ProjectItem {
    private String projectCode;
    private ArrayList projectItems = new ArrayList();

    public Project(String projectCode) {
        this.projectCode = projectCode;
    }

    public void addProjectItem(ProjectItem element) {
        projectItems.add(element);
    }

    @Override
    public ArrayList getProjectItems() {
        return projectItems;
    }

    @Override
    public void accept(ProjectVisitor visitor) {
        visitor.visitProject(this);
    }
}