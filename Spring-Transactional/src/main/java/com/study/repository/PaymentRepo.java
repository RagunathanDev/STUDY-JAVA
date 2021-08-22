package com.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.model.PaymentInfo;

public interface PaymentRepo extends JpaRepository<PaymentInfo, String> {

}
