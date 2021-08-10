package com.prokopovich.generics.dao;

import com.prokopovich.generics.model.User;

import java.util.Collection;

public interface UserDao extends GenericDao<User> {
    Collection<User> findAllByCurrentStatus(String currentStatus);
}