package com.example.springboot.SampleApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.SampleApp.entity.Client;
import com.example.springboot.SampleApp.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	public ClientService clientService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getClientById(@PathVariable Integer id){
		Client client = clientService.findById(id);
		return ResponseEntity.ok(client);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllClients(){
		List<Client> clients = clientService.findAll();
		return ResponseEntity.ok(clients);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Integer id){
		clientService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Client client, @PathVariable Integer id){
		Client clnt = clientService.update(id, client);
		return ResponseEntity.ok(clnt);
	}
	
	@PostMapping
	public ResponseEntity<?> saveClient(@RequestBody Client newClient){
		Client client = clientService.saveClient(newClient);
		return ResponseEntity.status(HttpStatus.CREATED).body(client);
	}
}
