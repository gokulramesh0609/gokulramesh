package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.model.Test;
import com.test.service.TestService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class TestController 
{

	@Autowired
	private TestService service;

	@PostMapping("/test")
	public Test create(@RequestBody Test test) 
	{
		return service.create(test);
	}
	
	@GetMapping("/tests")
	public List<Test> getAllQuestions() 
	{
		return service.getAllQuestions();
	}
	
	
	
	
	
}
