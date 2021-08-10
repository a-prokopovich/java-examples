package com.prokopovich.patterns.visitor;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        Project project = new Project("Project 1");
        Task firstTask = new Task("Task 1", 4.6);
        Task secondTask = new Task("Task 2", 8);
        project.addProjectItem(firstTask);
        project.addProjectItem(secondTask);
        Task firstTask1 = new Task("Task 11", 15);
        Task firstTask2 = new Task("Task 12", 2.2);
        firstTask.addProjectItem(firstTask1);
        firstTask.addProjectItem(firstTask2);

        ProjectTotalTimeVisitor visitor = new ProjectTotalTimeVisitor();
        visitProjectItem(project, visitor);
        System.out.println("Total project time: " + visitor.getTotalTime());
    }

    private static void visitProjectItem(ProjectItem item, ProjectVisitor visitor) {
        item.accept(visitor);
        if (item.getProjectItems() != null) {
            Iterator iterator = item.getProjectItems().iterator();
            while (iterator.hasNext()) {
                visitProjectItem((ProjectItem) iterator.next(), visitor);
            }
        }
    }
}
