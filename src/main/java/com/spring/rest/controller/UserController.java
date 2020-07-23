package com.spring.rest.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	
	@GetMapping(path="/{userID}")
	public String getUser(@PathVariable String userID) {
		return "GET user method is called with the userID: "+ userID;
	}
	
	
	/*
	 * @GetMapping //In this method both the request parameters are mandatory page
	 * and limit public String getUsers(@RequestParam(value="page") int
	 * page, @RequestParam(value="limit") int limit) { return
	 * "GET user method is called with page and limit: "+page +" and " +limit ; }
	 */
	
	@GetMapping //In this method both the request parameters are optional with the use of defaultValue
	//another way to make optional is to required = false but, the required will not work with primitive data types
	public String getUsers(@RequestParam(value="page", defaultValue="1") int page, 
			@RequestParam(value="limit", defaultValue="50") int limit,
			@RequestParam(value="sort", defaultValue="desc") String sort) 
	
	{
//		if(sort==null) sort="desc"; //this can be change via defuaultValue
		return "GET user method is called with page and limit: "+page +" and " +limit +" and sort: "+sort;
	}
	
	
	@PostMapping
	public String postUser() {
		return "POST method is called";
	}
	
	
	@PutMapping
	public String putUser() {
		return "PUT user method is called";
	}
	
	@DeleteMapping
	public String deletUser() {
		return "DELETE user method is called";
	}
	
	
	
	
}
