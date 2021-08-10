package com.prokopovich.patterns.visitor;

import java.util.ArrayList;

public interface ProjectItem {
    void accept(ProjectVisitor visitor);
    ArrayList getProjectItems();
}
