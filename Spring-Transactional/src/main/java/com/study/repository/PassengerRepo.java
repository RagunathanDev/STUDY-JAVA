package com.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.model.PassengerInfo;

public interface PassengerRepo extends JpaRepository<PassengerInfo, Long> {

}
