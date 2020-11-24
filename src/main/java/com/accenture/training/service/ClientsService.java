package com.accenture.training.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.training.domain.ClientsEntity;
import com.accenture.training.dto.ClientsTO;
import com.accenture.training.repository.ClientsRepository;

@Service
public class ClientsService {
	@Autowired
	ClientsRepository rep;

	@Autowired
	ModelMapper mapper;
	
	

	public List<ClientsTO> findAll() {
		List<ClientsEntity> findAll = rep.findAll();
		return findAll.stream().map( item -> {
			return mapper.map(item, ClientsTO.class); 
		}).collect(Collectors.toList());
	}
	public ClientsTO findById(String id) {
		Optional<ClientsEntity> clientLooked = rep.findById(id);
		ClientsTO clientTOLooked = mapper.map(clientLooked.get(),ClientsTO.class);
		return clientTOLooked;
	}
	
	public ClientsTO save(ClientsTO client) {
		ClientsEntity clientEntity = mapper.map(client, ClientsEntity.class);
		ClientsEntity clientSave = rep.save(clientEntity);
		return mapper.map(clientSave, ClientsTO.class);
	}
	public ClientsTO changeClient(ClientsTO client) {
		ClientsEntity clientEntity = mapper.map(client, ClientsEntity.class);
		ClientsEntity clientSave = rep.save(clientEntity);
		return mapper.map(clientSave, ClientsTO.class);
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
