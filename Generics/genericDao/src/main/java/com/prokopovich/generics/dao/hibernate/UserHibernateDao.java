package com.prokopovich.generics.dao.hibernate;

import com.prokopovich.generics.dao.UserDao;
import com.prokopovich.generics.model.User;

import javax.persistence.EntityManagerFactory;
import java.util.Collection;
import java.util.List;

public class UserHibernateDao extends GenericHibernateDao<User> implements UserDao {

    public UserHibernateDao(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory, User.class);
    }

    @Override
    public Collection<User> findAllByCurrentStatus(String currentStatus) {
        List<User> userList = (List<User>) findByParameter("currentStatus", currentStatus);
        return userList;
    }
}