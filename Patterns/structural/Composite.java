import java.util.ArrayList;
import java.util.Iterator;

public interface ProjectItem {
    double calculateTimeRequired();
}

public class Project implements ProjectItem {
    private String name;
    private ArrayList projectItem;

    public Project(String name) {
        this.name = name;
        projectItem = new ArrayList();
    }

    public void addProjectItem(ProjectItem item) {
        projectItem.add(item);
    }

    @Override
    public double calculateTimeRequired() {
        double totalTime = 0;
        Iterator items = projectItem.iterator();
        while (items.hasNext()) {
            ProjectItem item = (ProjectItem) items.next();
            totalTime += item.calculateTimeRequired();
        }
        return totalTime;
    }
}

public class Task implements ProjectItem {
    private String name;
    private double timeRequired;
    private ArrayList projectItem;

    public Task(String name, double timeRequired) {
        this.name = name;
        this.timeRequired = timeRequired;
        projectItem = new ArrayList();
    }

    public void addProjectItem(ProjectItem item) {
        projectItem.add(item);
    }

    @Override
    public double calculateTimeRequired() {
        double totalTime = timeRequired;
        Iterator items = projectItem.iterator();
        while (items.hasNext()) {
            ProjectItem item = (ProjectItem) items.next();
            totalTime += item.calculateTimeRequired();
        }
        return totalTime;
    }
}

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
        project.calculateTimeRequired();
    }
}



