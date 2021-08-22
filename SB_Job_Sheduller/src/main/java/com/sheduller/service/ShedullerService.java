package com.sheduller.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.sheduller.model.User;
import com.sheduller.repo.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ShedullerService {

	@Autowired
	private UserRepository repo;

	@Scheduled(fixedRate = 5000)
	public void saveUserDetails() {
		User user = new User();
		user.setName("User" + new Random().nextInt(12321));
		repo.save(user);
		System.out.println("Save user at :" + LocalDate.now() + " User :" + user);
	}

	@Scheduled(cron = "0/15 * * ? * * ")
	public void fetchUser() {

		List<User> user = repo.findAll();
		System.out.println("Fetch user Record size : " + user.size());
	}
}
