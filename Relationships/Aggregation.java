
public class Developer {
    private String fullName;
    private String position;
    private String email;

    public Developer(String fullName, String position, String email) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
    }

    @Override
    public String toString() {
        return "\n\tDeveloper: " +
                "fullName = " + fullName +
                ", position = " + position +
                ", email = " + email + ';';
    }
}

public class ProjectTeam {
    private String projectCode;
    private List<Developer> developerList;

    public ProjectTeam(String projectCode, List<Developer> developerList) {
        this.projectCode = projectCode;
        this.developerList = developerList;
    }

    @Override
    public String toString() {
        String teamStr = "ProjectTeam: " +
                "projectCode = " + projectCode +
                ", developers:";
        for (Developer developer : developerList) {
            teamStr += developer.toString();
        }
        return teamStr;
    }
}

public class Main {

    public static void main(String[] args) {
        List<Developer> developerList = new ArrayList<>();
        developerList.add(new Developer("John Jonson", "Senior Java Developer", "jj@n.com"));
        developerList.add(new Developer("Bob Peters", "Junior Java Developer", "bp@n.com"));
        developerList.add(new Developer("Rob Mol", "QA Engineer", "rm@n.com"));
        ProjectTeam projectTeam = new ProjectTeam("RFGT56D", developerList);
        System.out.println(projectTeam.toString());
    }
}
