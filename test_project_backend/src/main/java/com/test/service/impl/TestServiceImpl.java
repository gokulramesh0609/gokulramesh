package com.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.TestDao;
import com.test.model.Test;
import com.test.service.TestService;


@Service
public class TestServiceImpl implements TestService
{
	@Autowired
	private TestDao dao;

	@Override
	public Test create(Test test)
	{
		
		return dao.save(test);
	}

	@Override
	public List<Test> getAllQuestions() 
	{
		
		return dao.findAll();
	}

}
