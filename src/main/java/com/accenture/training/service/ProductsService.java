package com.accenture.training.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.training.domain.ProductsEntity;
import com.accenture.training.dto.ProductsTO;
import com.accenture.training.repository.ProductsRepository;

@Service
public class ProductsService {
	
	@Autowired
	ProductsRepository rep;

	@Autowired
	ModelMapper mapper;
	
	public List<ProductsTO> findAll(){
		List<ProductsEntity> findAll = rep.findAll();
		return findAll.stream().map( item -> {
			return mapper.map(item,  ProductsTO.class); 
		}).collect(Collectors.toList());
	}
	public ProductsTO findById(String id) {
		Optional<ProductsEntity> productLooked = rep.findById(id);
		ProductsTO productTOLooked = mapper.map(productLooked.get(),ProductsTO.class);
		return productTOLooked;
	} 
	
	public List<ProductsTO> findByKeyword(String keyword) {
		List<ProductsEntity> productsFromKeyword = rep.findByKeyword(keyword);
		return productsFromKeyword.stream().map( item -> {
			return mapper.map(item,  ProductsTO.class); 
		}).collect(Collectors.toList());
	}
	
	public ProductsTO save(ProductsTO product) {
		ProductsEntity prodEntity = mapper.map(product, ProductsEntity.class);
		ProductsEntity prodSave = rep.save(prodEntity);
		return mapper.map(prodSave, ProductsTO.class);
	}
	
	// Change a Product
	// Input: productTO
	// Return: if exists, update.
	//		   else, create.
	public ProductsTO changeProduct(ProductsTO product) {
		ProductsEntity prodEntity = mapper.map(product, ProductsEntity.class);
		ProductsEntity prodSave = rep.save(prodEntity);
		return mapper.map(prodSave, ProductsTO.class);
	}
	
	public boolean delete(String id) {
		try {
			rep.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	

}
