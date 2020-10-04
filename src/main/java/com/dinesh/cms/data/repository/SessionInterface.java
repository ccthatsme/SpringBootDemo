package com.dinesh.cms.data.repository;

import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;

public interface SessionInterface extends org.hibernate.Session {
    @Override
    default <T> Query<T> createQuery(String s, Class<T> aClass) {
        return null;
    }

    @Override
    default <T> Query<T> createQuery(CriteriaQuery<T> criteriaQuery) {
        return null;
    }

    @Override
    default Query createQuery(CriteriaUpdate criteriaUpdate) {
        return null;
    }

    @Override
    default Query createQuery(CriteriaDelete criteriaDelete) {
        return null;
    }

    @Override
    default <T> Query<T> createNamedQuery(String s, Class<T> aClass) {
        return null;
    }

    @Override
    default NativeQuery createSQLQuery(String s) {
        return null;
    }
}
