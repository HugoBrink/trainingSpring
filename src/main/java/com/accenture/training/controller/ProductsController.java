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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.training.dto.ProductsTO;
import com.accenture.training.service.ProductsService;

@RestController
@RequestMapping("/Product")
public class ProductsController {

	@Autowired
	ProductsService service;
	
	@GetMapping("")
	public List<ProductsTO> findAll(){
		return service.findAll();
	}
	
	@GetMapping("{productID}")
	public ProductsTO findById(@PathVariable("productID")  String id){
		return service.findById(id);
	}
	
	@GetMapping("find")
	public List<ProductsTO> findByKeyword(@RequestParam("keyword") String keyword){
		return service.findByKeyword(keyword);
	} 
	
	@PostMapping("")
	public ProductsTO save(@RequestBody ProductsTO product){
		return service.save(product);
	}
	@PutMapping("{productID}")
	public ProductsTO update(@PathVariable("productID")  String id, @RequestBody ProductsTO product){
		return service.changeProduct(product);
	}
	@DeleteMapping("{productID}")
	public Boolean deleteProduct(@PathVariable("productID")  String id){
		return service.delete(id);
	}
}
