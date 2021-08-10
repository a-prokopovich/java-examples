package com.prokopovich.patterns.visitor;

public interface ProjectVisitor {
    void visitProject(Project project);
    void visitTask(Task task);
}