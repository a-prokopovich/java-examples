package com.prokopovich.patterns.service;

public interface AccountService {
    Account createAccount(Account newAccount);
    List<Account> getAll();
    //...
}

public class ManagerAccountService implements Account {
    @Override
    private Account createAccount(Account newAccount) {
        //...
    }

    @Override
    private List<Account> getAll() {
        //...
    }
}

public class CustomerAccountService implements Account {
    @Override
    private Account createAccount(Account newAccount) {
        //...
    }

    @Override
    private List<Account> getAll() {
        //...
    }

    private boolean cleanBasket() {
        //...
    }
}

//////////////////////////////////////////

package com.prokopovich.patterns.factory;

public interface AccountServiceFactory {
    public AccountService addAccount();
    //...
}

public class ManagerAccountServiceFactory implements AccountServiceFactory {

    @Override
    public AccountService addAccount() {
        return new ManagerAccountService();
    }
}

public class CustomerAccountServiceFactory implements AccountServiceFactory {

    @Override
    public AccountService addAccount() {
        return new CustomerAccountService();
    }
}

//////////////////////////////////////////

public class Main {
    public static void main(String[] args) {
        // ...
        AccountServiceFactory accountFactory = null;
        if(account.type.equals("Manager")) {
            accountFactory = new ManagerAccountServiceFactory();
        }
        if(account.type.equals("Manager")) {
            accountFactory = new CustomerAccountServiceFactory();
        }
        AccountService accountService = accountFactory.addAccount();
        // ...
    }
}
