package com.accenture.training.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.training.domain.SalesOrderItemEntity;
import com.accenture.training.dto.SalesOrderItemTO;
import com.accenture.training.repository.SalesOrderItemRepository;

@Service
public class SalesOrderItemService {
	
	@Autowired
	SalesOrderItemRepository rep;

	@Autowired
	ModelMapper mapper;
	
	public List<SalesOrderItemTO> findAll(){
		List<SalesOrderItemEntity> findAll = rep.findAll();
		return findAll.stream().map( item -> {
			return mapper.map(item,  SalesOrderItemTO.class); 
		}).collect(Collectors.toList());
	}
	public SalesOrderItemTO findById(String id) {
		Optional<SalesOrderItemEntity> salesOrderItemLooked = rep.findById(id);
		SalesOrderItemTO salesOrderItemTOLooked = mapper.map(salesOrderItemLooked.get(),SalesOrderItemTO.class);
		return salesOrderItemTOLooked;
	} 
	
	/*
	public List<SalesOrderTO> findByKeyword(String keyword) {
		List<SalesOrderEntity> salesOrderFromKeyword = rep.findByKeyword(keyword);
		return salesOrderFromKeyword.stream().map( item -> {
			return mapper.map(item,  SalesOrderTO.class); 
		}).collect(Collectors.toList());
	}*/
	
	public SalesOrderItemTO save(SalesOrderItemTO salesOrderItem) {
		SalesOrderItemEntity salesOrderItemEntity = mapper.map(salesOrderItem, SalesOrderItemEntity.class);
		SalesOrderItemEntity salesOrderItemSave = rep.save(salesOrderItemEntity);
		return mapper.map(salesOrderItemSave, SalesOrderItemTO.class);
	}
	
	// Change a Product
	// Input: productTO
	// Return: if exists, update.
	//		   else, create.
	public SalesOrderItemTO changeProduct(SalesOrderItemTO salesItem) {
		SalesOrderItemEntity salesOrderItemEntity = mapper.map(salesItem, SalesOrderItemEntity.class);
		SalesOrderItemEntity salesOrderItemSave = rep.save(salesOrderItemEntity);
		return mapper.map(salesOrderItemSave, SalesOrderItemTO.class);
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
