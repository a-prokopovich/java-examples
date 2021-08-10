package com.prokopovich.generics.dao;

import com.prokopovich.generics.model.Account;

import java.util.Collection;

public interface AccountDao extends GenericDao<Account> {

    Collection<Account> findAllByEmail(String email);

}