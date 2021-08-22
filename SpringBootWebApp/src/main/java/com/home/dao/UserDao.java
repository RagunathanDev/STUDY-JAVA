package com.home.dao;

import org.springframework.data.repository.CrudRepository;

import com.home.model.User;


public interface UserDao extends CrudRepository<User, Integer> {

}
