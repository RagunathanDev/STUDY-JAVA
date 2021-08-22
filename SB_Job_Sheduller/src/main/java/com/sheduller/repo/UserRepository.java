package com.sheduller.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sheduller.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
