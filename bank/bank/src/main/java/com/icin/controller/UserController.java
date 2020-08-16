package com.icin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.icin.model.Admin;
import com.icin.model.User;
import com.icin.service.UserService;
import com.icin.serviceImpl.RegisterService;
import com.icin.model.PrimaryAccount;
import com.icin.model.SavingsAccount;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class UserController {

	
	private User user1;
	@Autowired
	RegisterService registerService;

	@Autowired
	UserService userService;
	
	@RequestMapping(path="/hello", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200")
	public String testMessage()
	{
		return "WELCOME";
	}

	
	@RequestMapping(path="/register", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:4200")
	public User registerAddUser(@RequestBody User user)
	{
		User Obj;
		Obj=registerService.addUser(user);
		return Obj;
	}
	
	
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:4200")
	public User doLogin(@RequestBody User user) throws Exception
	{
		String loginMail = user.getMailid();
		String loginPassword = user.getPassword();
		User Obj = null;
		if(loginMail != null && loginPassword != null)
		{
			Obj = registerService.matchEmailPassword(loginMail, loginPassword);
		}
		
		if(Obj == null)
		{
			throw new Exception("please sign up");
		}
		return Obj; 
	}
	
	
	@RequestMapping(path = "/admin", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:4200")
	public void doAdminLogin(@RequestBody Admin admin) throws Exception
	{
		String adminemail = admin.getEmailid();
		String adminpassword = admin.getPassword();
		
		if(adminemail.equals("admin") && adminpassword.equals("admin"))
		{
			System.out.println("admin successfully login");
		}
		else
		{
			throw new Exception("credentials are wrong");
		}
		
		
	}
	
	@PostMapping("/home" )
	@CrossOrigin(origins = "http://localhost:4200")
	public List getHome(@RequestBody String email) {
		List<Object> accounts = new ArrayList<Object>();
		user1 = userService.findByEmail(email);
		System.out.println(user1);
		PrimaryAccount primaryAccount = user1.getPrimaryAccount();
	    SavingsAccount savingsAccount = user1.getSavingsAccount();
	    accounts.add(savingsAccount);
	    accounts.add(primaryAccount);
	    return accounts;
    }
	

	
}
