package com.example.springboot.SampleApp.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.example.springboot.SampleApp.gen.DeleteById;
import com.example.springboot.SampleApp.gen.FindAll;
import com.example.springboot.SampleApp.gen.FindAllResponse;
import com.example.springboot.SampleApp.gen.FindById;
import com.example.springboot.SampleApp.gen.FindByIdResponse;
import com.example.springboot.SampleApp.gen.SaveClient;
import com.example.springboot.SampleApp.gen.SaveClientResponse;
import com.example.springboot.SampleApp.gen.Update;
import com.example.springboot.SampleApp.gen.UpdateResponse;


@Service
public class SoapClientService{

	private static final String URI = "http://localhost:8082/ws";
	
	@Autowired
	private Jaxb2Marshaller marshaller;
	
	private WebServiceTemplate template;
	
	public FindByIdResponse getClientId(FindById request) {
		template = new WebServiceTemplate(marshaller);
		FindByIdResponse response = (FindByIdResponse) template.marshalSendAndReceive(URI, request);
		return response;
	}
	
	public FindAllResponse getAllClient(FindAll request) {
		FindAllResponse response = new FindAllResponse();
		response = (FindAllResponse) template.marshalSendAndReceive(URI, request);
		return response;
	}
	
	public UpdateResponse updateClient(Update request) {
		UpdateResponse response = new UpdateResponse();
		response = (UpdateResponse) template.marshalSendAndReceive(URI, request);
		return response;
	}
	
	public SaveClientResponse saveClient(SaveClient request) {
		SaveClientResponse response = new SaveClientResponse();
		response = (SaveClientResponse) template.marshalSendAndReceive(URI, request);
		return response;
	}
	
	public void deleteClient(DeleteById request) {
		template.marshalSendAndReceive(URI, request);
	}
}
