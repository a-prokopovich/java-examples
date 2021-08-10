import java.io.File;
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

public abstract class ProjectDecorator implements ProjectItem {
    private ProjectItem projectItem;

    protected ProjectItem getProjectItem() {
        return projectItem;
    }

    protected void setProjectItem(ProjectItem projectItem) {
        this.projectItem = projectItem;
    }

    @Override
    public double calculateTimeRequired() {
        return projectItem.calculateTimeRequired();
    }
}

public class CommentProjectItem extends ProjectDecorator {
    private ArrayList comments;

    public CommentProjectItem(String comment) {
        addComment(comment);
    }

    public void addComment(String comment) {
        comments.add(comment);
    }

    @Override
    public String toString() {
        return getProjectItem().toString() + " Comments: " + comments;
    }
}

public class AttachmentProjectItem extends ProjectDecorator {
    private ArrayList attachments;

    public AttachmentProjectItem(File attachment) {
        attachments = new ArrayList();
        addAttachment(attachment);
    }

    public void addAttachment(File attachment) {
        attachments.add(attachment);
    }

    @Override
    public String toString() {
        return getProjectItem().toString() + " Attachments: " + attachments;
    }
}

public class Main {

    public static void main(String[] args) {
        Project firstProject = new Project("Project 1");
        ProjectDecorator attachmentDecorator = new AttachmentProjectItem(new File("Attachment1.txt"));
        ProjectDecorator commentDecorator = new CommentProjectItem("Comment1");
        attachmentDecorator.setProjectItem(firstProject);
        commentDecorator.setProjectItem(attachmentDecorator);
        System.out.println(commentDecorator);
    }
}



