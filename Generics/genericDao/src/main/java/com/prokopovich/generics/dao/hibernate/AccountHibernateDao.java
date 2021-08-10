package com.prokopovich.generics.dao.hibernate;

import com.prokopovich.generics.dao.AccountDao;
import com.prokopovich.generics.model.Account;

import javax.persistence.EntityManagerFactory;
import java.util.Collection;

public class AccountHibernateDao extends GenericHibernateDao<Account> implements AccountDao {

    public AccountHibernateDao(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory, Account.class);
    }

    @Override
    public Collection<Account> findAllByEmail(String email) {
        return findByParameter("email", email);
    }
}