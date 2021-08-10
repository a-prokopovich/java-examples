package com.prokopovich.patterns.visitor;

public class ProjectTotalTimeVisitor implements ProjectVisitor {
    private double totalTime;

    public double getTotalTime() {
        return totalTime;
    }

    public void resetTotalTime() {
        totalTime = 0.0;
    }

    @Override
    public void visitProject(Project project) { }

    @Override
    public void visitTask(Task task) {
        totalTime += task.getRimeRequired();
    }
}