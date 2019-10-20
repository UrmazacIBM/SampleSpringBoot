package com.example.springboot.SampleApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.springboot.SampleApp.gen.DeleteById;
import com.example.springboot.SampleApp.gen.FindAllResponse;
import com.example.springboot.SampleApp.gen.FindById;
import com.example.springboot.SampleApp.gen.FindByIdResponse;
import com.example.springboot.SampleApp.gen.SaveClient;
import com.example.springboot.SampleApp.gen.SaveClientResponse;
import com.example.springboot.SampleApp.gen.Update;
import com.example.springboot.SampleApp.gen.UpdateResponse;
import com.example.springboot.SampleApp.service.ClientService;

@Endpoint
public class ClientEndpoint {

	private static final String NAMESPACE_URI = "http://www.example.com/springboot/SampleApp/gen";
	
	@Autowired
	public ClientService clientService;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "findById")
	@ResponsePayload
	public FindByIdResponse getClient(@RequestPayload FindById request) {
		FindByIdResponse response =new FindByIdResponse();
		response.setReturn(clientService.findById(request.getArg0()));
		
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "findAll")
	@ResponsePayload
	public FindAllResponse getAllClient() {
		FindAllResponse response = new FindAllResponse();
		response.setReturn(clientService.findAll());
		
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "update")
	@ResponsePayload
	public UpdateResponse updateClient(@RequestPayload Update request) {
		UpdateResponse response = new UpdateResponse();
		response.setReturn(clientService.update(request.getArg0(), request.getArg1()));
		
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "saveClient")
	@ResponsePayload
	public SaveClientResponse saveClient(@RequestPayload SaveClient request) {
		SaveClientResponse response = new SaveClientResponse();
		response.setReturn(clientService.saveClient(request.getArg0()));
		
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteById")
	@ResponsePayload
	public void deleteClient(@RequestPayload DeleteById request) {
		clientService.deleteById(request.getArg0());
	}
}
