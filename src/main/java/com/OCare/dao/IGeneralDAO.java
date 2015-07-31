package com.OCare.dao;

import java.util.List;

/**
 * Created by mark on 6/30/15.
 */
public interface IGeneralDAO<T> {

    T queryById(String id);
    List<T> queryAll();
    void insert(T t);
    void delete(T t);
    void update(T t);
}
