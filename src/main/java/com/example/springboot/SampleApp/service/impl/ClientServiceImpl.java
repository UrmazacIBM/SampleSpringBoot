package com.example.springboot.SampleApp.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.SampleApp.entity.Client;
import com.example.springboot.SampleApp.exception.NotFoundException;
import com.example.springboot.SampleApp.repository.ClientRepository;
import com.example.springboot.SampleApp.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	
	private static final Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);

	@Autowired
	public ClientRepository clientRepo;
	
	public Client findById(Integer id) {
		Client client = clientRepo.findById(id);
		if(client == null) {
			logger.error("No record found for id: " + id);
			throw new NotFoundException("No record found for id: " + id);
		}else {
			return client;
		}
	}

	public List<Client> findAll() {
		return clientRepo.findAll();
	}
	
	public void deleteById(Integer id) {
		Client client = clientRepo.findById(id);
		if(client == null) {
			logger.error("No record found for id: " + id);
			throw new NotFoundException("No record found for id: " + id);
		}else {
			clientRepo.deleteById(id);
		}
	}
	
	public Client saveClient(Client client) {
		return clientRepo.saveClient(client);
	}
	
	public Client update(Integer id, Client client) {
		Client cls = clientRepo.findById(id);
		if(cls == null) {
			logger.error("No record found for id: " + id);
			throw new NotFoundException("No record found for id: " + id);
		}else {
			return clientRepo.update(id, client);
		}
	}
}
