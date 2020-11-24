package com.accenture.training.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.training.domain.UsersEntity;
import com.accenture.training.dto.UsersTO;
import com.accenture.training.repository.UsersRepository;

@Service
public class UsersService {
	@Autowired
	UsersRepository rep;

	@Autowired
	ModelMapper mapper;
	
	

	public List<UsersTO> findAll() {
		List<UsersEntity> findAll = rep.findAll();
		return findAll.stream().map( item -> {
			return mapper.map(item, UsersTO.class); 
		}).collect(Collectors.toList());
	}
	public UsersTO findById(String id) {
		Optional<UsersEntity> clientLooked = rep.findById(id);
		UsersTO clientTOLooked = mapper.map(clientLooked.get(),UsersTO.class);
		return clientTOLooked;
	}
	
	public UsersTO save(UsersTO user) {
		UsersEntity userEntity = mapper.map(user, UsersEntity.class);
		UsersEntity userSave = rep.save(userEntity);
		return mapper.map(userSave, UsersTO.class);
	}
	public UsersTO changeClient(UsersTO user) {
		UsersEntity userEntity = mapper.map(user, UsersEntity.class);
		UsersEntity userSave = rep.save(userEntity);
		return mapper.map(userSave, UsersTO.class);
	}
	public Boolean delete(String id) {
		try {
			rep.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	

	
	
}
