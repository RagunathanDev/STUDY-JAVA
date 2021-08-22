package com.springMVC;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springMVC.service.AddService;

@Controller
public class AddController {

	@Autowired
	private AddService addserv;

	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(request.getParameter("v1"));

		ModelAndView mav = new ModelAndView();

		int value1 = Integer.parseInt(request.getParameter("v1"));
		int value2 = Integer.parseInt(request.getParameter("v2"));

		int result = addserv.add(value1, value2);

		mav.addObject("result", result);
		mav.setViewName("display");
		return mav;

	}
}
