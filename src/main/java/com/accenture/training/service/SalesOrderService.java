package com.accenture.training.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.training.domain.SalesOrderEntity;
import com.accenture.training.dto.SalesOrderTO;
import com.accenture.training.repository.SalesOrderRepository;

@Service
public class SalesOrderService {
	
	@Autowired
	SalesOrderRepository rep;

	@Autowired
	ModelMapper mapper;
	
	public List<SalesOrderTO> findAll(){
		List<SalesOrderEntity> findAll = rep.findAll();
		return findAll.stream().map( item -> {
			return mapper.map(item,  SalesOrderTO.class); 
		}).collect(Collectors.toList());
	}
	public SalesOrderTO findById(String id) {
		Optional<SalesOrderEntity> salesOrderLooked = rep.findById(id);
		SalesOrderTO salesOrderTOLooked = mapper.map(salesOrderLooked.get(),SalesOrderTO.class);
		return salesOrderTOLooked;
	} 
	
	/*
	public List<SalesOrderTO> findByKeyword(String keyword) {
		List<SalesOrderEntity> salesOrderFromKeyword = rep.findByKeyword(keyword);
		return salesOrderFromKeyword.stream().map( item -> {
			return mapper.map(item,  SalesOrderTO.class); 
		}).collect(Collectors.toList());
	}*/
	
	public SalesOrderTO save(SalesOrderTO salesOrder) {
		SalesOrderEntity salesOrderEntity = mapper.map(salesOrder, SalesOrderEntity.class);
		SalesOrderEntity salesOrderSave = rep.save(salesOrderEntity);
		return mapper.map(salesOrderSave, SalesOrderTO.class);
	}
	
	// Change a Product
	// Input: productTO
	// Return: if exists, update.
	//		   else, create.
	public SalesOrderTO changeProduct(SalesOrderTO sales) {
		SalesOrderEntity salesOrderEntity = mapper.map(sales, SalesOrderEntity.class);
		SalesOrderEntity salesOrderSave = rep.save(salesOrderEntity);
		return mapper.map(salesOrderSave, SalesOrderTO.class);
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
