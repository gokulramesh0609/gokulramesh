package com.test;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.test.dao.TestDao;
import com.test.model.Test;

@SpringBootApplication
public class TestProjectBackendApplication {

	public static void main(String[] args) 
	{
		SpringApplication.run(TestProjectBackendApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner(TestDao dao)
	{
		return args-> 
		{
			dao.save(new Test("who is the current captain of Indian cricket team ?","Dhoni"));
			dao.save(new Test("what does LBW stands for ?","Leg Before Wicket"));
			dao.save(new Test("Dravid is also called as ?","Great Wall Of India"));
			dao.save(new Test("who is short Tempered in Indian cricket team ?","Virat kohli"));
			dao.save(new Test("how many world cup does India have ?","Two"));
		};
	}

}
