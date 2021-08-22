package com.home.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.home.dao.UserDao;
import com.home.model.User;

@Controller
public class HomeController {

	@Autowired
	UserDao userDao;

	@RequestMapping("/")
	private ModelAndView getHome() {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("home");
		return mav;
	}

	@RequestMapping("/addUser")
	private ModelAndView addUser(User userModel) {
		ModelAndView mav = new ModelAndView();
		userDao.save(userModel);
		mav.setViewName("home");
		return mav;
	}

//	ResponseBody -> added for return the REST data (ie. return the JSON data to the end user)
	@RequestMapping("/getAllUser")
	@ResponseBody
	private List<User> getAllUser() {
		return (List<User>) userDao.findAll();
	}

	@RequestMapping("/user/{id}")
	@ResponseBody
	private User getById(@PathVariable int id) {
		return userDao.findById(id).orElse(new User());
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@ResponseBody
	private User getUser(@RequestBody User user) {
		return userDao.findById(user.getId()).orElse(new User());
	}

	@RequestMapping(method = RequestMethod.POST, value = "/update")
	@ResponseBody
	private User updateUser(@RequestBody User user) {
		User updateUser = userDao.findById(user.getId()).orElse(new User());

		if (updateUser != null)
			updateUser.setName(user.getName());
		else
			return updateUser;
		return userDao.save(updateUser);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/delete", produces = "application/json")
	private List<User> deleteUser(@RequestBody User user) {
		userDao.deleteById(user.getId());
		return (List<User>) userDao.findAll();
	}

}
