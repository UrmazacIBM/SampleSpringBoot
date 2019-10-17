package com.example.springboot.SampleApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.sample.springsoap.gen.GetClientRequest;
import com.sample.springsoap.gen.GetClientResponse;

@Endpoint
public class ClientEndpoint {

	private static final String NAMESPACE_URI = "http://www.sample.com/springsoap/gen";
	
	@Autowired
	public ClientRepository clientRepo;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getClientRequest")
	@ResponsePayload
	public GetClientResponse getClient(@RequestPayload GetClientRequest request) {
		GetClientResponse response = new GetClientResponse();
		response.setClient(clientRepo.findById(request.getId()));
		
		return response;
	}
}
