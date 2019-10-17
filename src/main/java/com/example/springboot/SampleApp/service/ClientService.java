package com.example.springboot.SampleApp.service;

import com.example.springboot.SampleApp.entity.Client;

public interface ClientService {

	Client findById(Integer id);
}
