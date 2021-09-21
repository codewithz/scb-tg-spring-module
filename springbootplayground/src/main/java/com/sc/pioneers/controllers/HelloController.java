package com.sc.pioneers.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping(path="/hello",method = RequestMethod.GET)
	public String sayHello()
	{
		return "Hello Pioneers!!";
	}
	
	@GetMapping("/welcome")
	public String welcomeMessage()
	{
		return "Welcome to Standard Chartered Bank";
	}
	
	@GetMapping("/names")
	public List<String> getCandidateNames()
	{
		List<String> names=new ArrayList<>();
		names.add("Radha");
		names.add("Rohan");
		names.add("Akshit");
		names.add("Nitya");
		
		return names;
	}
	
	@GetMapping("/user/{id}")
	public String testPathVariable(@PathVariable int id)
	{
		String message="User at ID# "+id+" is Tom";
		return message;
	}
	
	@GetMapping("/order")
	public String testRequestParameter(@RequestParam int id)
	{
		String message="Order at ID# "+id+" is for Tom";
		return message;
	}

}
