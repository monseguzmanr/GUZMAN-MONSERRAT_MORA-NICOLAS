package com.backend.parcial.dao;

import java.util.List;

public interface IDao<T> {

    List<T> listAll();

    T save(T t);

}
