package com.test.service;

import java.util.List;

import com.test.model.Test;

public interface TestService 
{
	public Test create(Test test);
	public List<Test> getAllQuestions();
}
