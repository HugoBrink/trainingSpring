package com.accenture.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.training.domain.ClientsEntity;

public interface ClientsRepository extends JpaRepository<ClientsEntity, String>{

}
