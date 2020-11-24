package com.accenture.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.training.dto.UsersTO;
import com.accenture.training.service.UsersService;

@RestController
@RequestMapping("/User")
public class UsersController {

	@Autowired
	UsersService service;
	
	@GetMapping("")
	public List<UsersTO> save(){
		return service.findAll();
	}
	
	@GetMapping("{userID}")
	public UsersTO findById(@PathVariable("userID")  String id){
		return service.findById(id);
	}
	
	@PostMapping("")
	public UsersTO save(@RequestBody UsersTO user){
		return service.save(user);
	}
	@PutMapping("{userID}")
	public UsersTO update(@PathVariable("userID") String id, @RequestBody UsersTO user){
		return service.changeClient(user);
	}
	@DeleteMapping("{userID}")
	public Boolean deleteClient(@PathVariable("userID") String id){
		return service.delete(id);
	}
}
