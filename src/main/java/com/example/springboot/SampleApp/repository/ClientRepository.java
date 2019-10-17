package com.example.springboot.SampleApp.repository;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.example.springboot.SampleApp.entity.Client;

@Component
public class ClientRepository {

	private static final Map<Integer, Client> clients = new HashMap<>();
	
	@PostConstruct
	public void init() {
		Client clientOne = new Client();
		clientOne.setId(1);
		clientOne.setFirtName("John");
		clientOne.setLastName("Doe");
		clientOne.setGender("Male");
		
		clients.put(clientOne.getId(), clientOne);
		
		Client clientTwo = new Client();
		clientTwo.setId(2);
		clientTwo.setFirtName("Maria");
		clientTwo.setLastName("Cruz");
		clientTwo.setGender("Female");
		
		clients.put(clientTwo.getId(), clientTwo);
		
		Client clientThree = new Client();
		clientThree.setId(3);
		clientThree.setFirtName("Chris");
		clientThree.setLastName("Doe");
		clientThree.setGender("Male");
		
		clients.put(clientThree.getId(), clientThree);
		
	}
	
	public Client findById(Integer id) {
		return clients.get(id);
	}
}
