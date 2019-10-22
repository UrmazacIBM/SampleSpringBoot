package com.example.springboot.SampleApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.SampleApp.client.service.SoapClientService;
import com.example.springboot.SampleApp.gen.DeleteById;
import com.example.springboot.SampleApp.gen.FindAll;
import com.example.springboot.SampleApp.gen.FindAllResponse;
import com.example.springboot.SampleApp.gen.FindById;
import com.example.springboot.SampleApp.gen.FindByIdResponse;
import com.example.springboot.SampleApp.gen.SaveClient;
import com.example.springboot.SampleApp.gen.SaveClientResponse;
import com.example.springboot.SampleApp.gen.Update;
import com.example.springboot.SampleApp.gen.UpdateResponse;

@RestController
@RequestMapping("/client")
public class SoapClientController {

	@Autowired
	private SoapClientService clientService;
	
	@PostMapping("/")
	public FindByIdResponse getClientId(@RequestBody FindById request) {
		return clientService.getClientId(request);
	}
	
	@PostMapping("/all")
	public FindAllResponse getAllClient(@RequestBody FindAll request) {
		return clientService.getAllClient(request);
	}
	
	@PostMapping("/update")
	public UpdateResponse updateClient(@RequestBody Update request) {
		return clientService.updateClient(request);
	}
	
	@PostMapping("/save")
	public SaveClientResponse saveClient(@RequestBody SaveClient request) {
		return clientService.saveClient(request);
	}
	
	@PostMapping("/delete")
	public void deleteClient(@RequestBody DeleteById request) {
		clientService.deleteClient(request);
	}
}
