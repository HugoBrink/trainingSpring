package com.accenture.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.accenture.training.domain.ProductsEntity;
import com.accenture.training.domain.SalesOrderEntity;

public interface SalesOrderRepository extends JpaRepository<SalesOrderEntity, String>{
	@Query("Select k from ProductsEntity as k where k.name like :keyword or k.manufacturer like :keyword")
    public List<ProductsEntity> findByKeyword(@Param("keyword") String keyword);
}
