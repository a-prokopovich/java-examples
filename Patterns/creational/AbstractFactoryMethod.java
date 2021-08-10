package com.prokopovich.projectmanagement.dao;

public interface ProjectDao {
    Project create(Project newProject);
    Project findOne(int id);
    //...
}

public interface TaskDao {
    Task create(Task newTask);
    Task findOne(int id);
    boolean assignTask(int id);
    //...
}

//////////////////////////////////////////////////

package com.prokopovich.projectmanagement.mysqldao;

public class ProjectMySqlDao implements ProjectDao {

    @Override
    public Project create(Project newProject) {
        //...
    }

    @Override
    public Project findOne(int id) {
        //...
    }
}

public class TaskMySqlDao implements TaskDao {

    @Override
    public Task create(Task newTask) {
        //...
    }

    @Override
    public Task findOne(int id) {
        //...
    }

    @Override
    public boolean assignTask(int id) {
        //...
    }
}

//////////////////////////////////////////////////

package com.prokopovich.projectmanagement.nosqldao;

public class ProjectNoSqlDao implements ProjectDao {

    @Override
    public Project create(Project newProject) {
        //...
    }

    @Override
    public Project findOne(int id) {
        //...
    }
}

public class TaskNoSqlDao implements TaskDao {

    @Override
    public Task create(Task newTask) {
        //...
    }

    @Override
    public Task findOne(int id) {
        //...
    }

    @Override
    public boolean assignTask(int id) {
        //...
    }
}

//////////////////////////////////////////////////

package com.prokopovich.projectmanagement.factory;

public interface DaoFactory {

    ProjectDao getProjectDao();
    TaskDao getTaskDao();
    //...
}

public class MySqlDaoFactory extends DaoFactory {

    private static BasicDataSource dataSource = new BasicDataSource();

    static {
        Properties mySqlProperties = new PropertiesUtil()
                .getProperties("mysql.properties");
        // … set dataSource properties
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    @Override
    public ProjectDao getProjectDao() {
        return new ProjectMySqlDao();
    }

    @Override
    public TaskDao getTaskDao() {
        return new TaskMySqlDao();
    }
}


public class NoSqlDaoFactory extends DaoFactory {

    @Override
    public ProjectDao getProjectDao() {
        return new ProjectMySqlDao();
    }

    @Override
    public TaskDao getTaskDao() {
        return new TaskMySqlDao();
    }
}


public class DaoFactoryProvider {

    public static DaoFactory getDAOFactory(DatabaseType whichFactory) {
        switch (whichFactory) {
            case MYSQL:
                return new MySqlDaoFactory();
            case NOSQL:
                return new NoSqlDaoFactory();
            default:
                return null;
        }
    }
}
