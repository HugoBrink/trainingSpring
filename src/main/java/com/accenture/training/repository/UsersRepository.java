package com.accenture.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.training.domain.UsersEntity;

public interface UsersRepository extends JpaRepository<UsersEntity, String>{

}
