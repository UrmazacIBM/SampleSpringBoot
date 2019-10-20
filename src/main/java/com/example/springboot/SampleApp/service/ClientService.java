package com.example.springboot.SampleApp.service;

import java.util.List;

import com.example.springboot.SampleApp.gen.Client;



//@WebService(name = "ClientService")
//@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL)
public interface ClientService {
	Client findById(Integer id);
	List<Client> findAll();
	void deleteById(Integer id);
	Client saveClient(Client client);
	Client update(Integer id, Client client);
}
