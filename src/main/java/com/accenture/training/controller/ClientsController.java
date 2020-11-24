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

import com.accenture.training.dto.ClientsTO;
import com.accenture.training.service.ClientsService;

@RestController
@RequestMapping("/Client")
public class ClientsController {

	@Autowired
	ClientsService service;
	
	@GetMapping("")
	public List<ClientsTO> save(){
		return service.findAll();
	}
	
	@GetMapping("{clientID}")
	public ClientsTO findById(@PathVariable("clientID")  String id){
		return service.findById(id);
	}
	
	@PostMapping("")
	public ClientsTO save(@RequestBody ClientsTO client){
		return service.save(client);
	}
	@PutMapping("{clientID}")
	public ClientsTO update(@PathVariable("clientID") String id, @RequestBody ClientsTO client){
		return service.changeClient(client);
	}
	@DeleteMapping("{clientID}")
	public Boolean deleteClient(@PathVariable("clientID") String id){
		return service.delete(id);
	}
}
