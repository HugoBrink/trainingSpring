package com.accenture.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.training.domain.SalesOrderItemEntity;

public interface SalesOrderItemRepository extends JpaRepository<SalesOrderItemEntity, String>{

}
