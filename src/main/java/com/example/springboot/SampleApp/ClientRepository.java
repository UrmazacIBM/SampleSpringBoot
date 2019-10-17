package com.example.springboot.SampleApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.sample.springsoap.gen.Client;

@Component
public class ClientRepository {

	private static Map<Integer, Client> clients = new HashMap<>();
	
	@PostConstruct
	public void init() {
		Client clientOne = new Client();
		clientOne.setId(1);
		clientOne.setFirstName("John");
		clientOne.setLastName("Doe");
		clientOne.setGender("Male");
		
		clients.put(clientOne.getId(), clientOne);
		
		Client clientTwo = new Client();
		clientTwo.setId(2);
		clientTwo.setFirstName("Maria");
		clientTwo.setLastName("Cruz");
		clientTwo.setGender("Female");
		
		clients.put(clientTwo.getId(), clientTwo);
		
		Client clientThree = new Client();
		clientThree.setId(3);
		clientThree.setFirstName("Chris");
		clientThree.setLastName("Doe");
		clientThree.setGender("Male");
		
		clients.put(clientThree.getId(), clientThree);
		
	}
	
	public Client findById(Integer id) {
		return clients.get(id);
	}
	
	public List<Client> findAll(){
		List<Client> cls = new ArrayList<Client>();
		cls = clients.values().parallelStream().collect(Collectors.toList());
		return cls;
	}
	
	public void deleteById(Integer id) {
		clients.values().removeIf(x -> id == x.getId());
		//clients.forEach((k, v) -> System.out.println((k + ":" + v)));
	}
	
	public Client saveClient(Client client) {
		clients.put(client.getId(), client);
		return client;
	}
	
	public Client update(Integer id, Client client) {
		clients.replace(id, client);
		return client;
	}
}
