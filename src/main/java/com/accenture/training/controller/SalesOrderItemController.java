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

import com.accenture.training.dto.SalesOrderItemTO;
import com.accenture.training.dto.SalesOrderTO;
import com.accenture.training.service.SalesOrderItemService;

@RestController
@RequestMapping("/SalesOrderItem")
public class SalesOrderItemController {

	@Autowired
	SalesOrderItemService service;
	
	@GetMapping("")
	public List<SalesOrderItemTO> findAll(){
		return service.findAll();
	}
	
	@GetMapping("{salesOrderItemID}")
	public SalesOrderItemTO findById(@PathVariable("salesOrderItemID")  String id){
		return service.findById(id);
	}
	/*
	@GetMapping("find")
	public List<SalesOrderTO> findByKeyword(@RequestParam("keyword") String keyword){
		return service.findByKeyword(keyword);
	} */
	
	@PostMapping("")
	public SalesOrderItemTO save(@RequestBody SalesOrderItemTO salesOrderItem){
		return service.save(salesOrderItem);
	}
	@PutMapping("{salesOrderItemID}")
	public SalesOrderItemTO update(@PathVariable("salesOrderItemID")  String id, @RequestBody SalesOrderItemTO salesOrderItem){
		return service.changeProduct(salesOrderItem);
	}
	@DeleteMapping("{salesOrderItemID}")
	public Boolean deleteProduct(@PathVariable("salesOrderItemID")  String id){
		return service.delete(id);
	}
}
