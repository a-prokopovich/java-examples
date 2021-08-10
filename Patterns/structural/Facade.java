public class Action {
    private int accountId;
    private String type;
    private Date date;

    public void addAction(int accountId, String type) {
        this.type = type;
        date = new Date();
        //add in database
    }
}

public class Account {

    private int id;
    private String name;
    // ...


    public int getId() {
        return id;
    }

    public Account addAccount(String name) {
        this.name = name;
        //add in database
        //id generated in database
        return this;
    }
}

// Facade
public class AccountService {

    public void addNewAccount(String name) {
        Account newAccount = new Account();
        newAccount = newAccount.addAccount(name);
        Action newAction = new Action();
        newAction.addAction(newAccount.getId(), "CREATE");
    }

    //...
}

public class Main {

    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        accountService.addNewAccount("Tom");
    }
}



