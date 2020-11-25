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

import com.accenture.training.dto.SalesOrderTO;
import com.accenture.training.service.SalesOrderService;

@RestController
@RequestMapping("/SalesOrder")
public class SalesOrderController {

	@Autowired
	SalesOrderService service;
	
	@DeleteMapping("{salesOrderID}")
	public Boolean deleteProduct(@PathVariable("salesOrderID")  String id){
		return service.delete(id);
	}
	
	@GetMapping("")
	public List<SalesOrderTO> findAll(){
		return service.findAll();
	}
	
	@GetMapping("{salesOrderID}")
	public SalesOrderTO findById(@PathVariable("salesOrderID")  String id){
		return service.findById(id);
	}
	/*
	@GetMapping("find")
	public List<SalesOrderTO> findByKeyword(@RequestParam("keyword") String keyword){
		return service.findByKeyword(keyword);
	} */
	@PostMapping("")
	public SalesOrderTO save(@RequestBody SalesOrderTO salesOrder){
		return service.save(salesOrder);
	}
	@PutMapping("{salesOrderID}")
	public SalesOrderTO update(@PathVariable("salesOrderID")  String id, @RequestBody SalesOrderTO salesOrder){
		return service.changeProduct(salesOrder);
	}
}
