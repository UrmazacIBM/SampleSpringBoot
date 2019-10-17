package com.example.springboot.SampleApp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.SampleApp.entity.Client;
import com.example.springboot.SampleApp.repository.ClientRepository;
import com.example.springboot.SampleApp.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	public ClientRepository clientRepo;
	
	public Client findById(Integer id) {
		return clientRepo.findById(id);
	}
}
