package com.example.springboot.SampleApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.SampleApp.entity.Client;
import com.example.springboot.SampleApp.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	public ClientService clientService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getClientById(@PathVariable Integer id){
		Client client = clientService.findById(id);
		return ResponseEntity.ok(client);
	}
}
