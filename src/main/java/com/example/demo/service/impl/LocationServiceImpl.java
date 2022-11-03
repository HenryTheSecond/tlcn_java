package com.example.demo.service.impl;

import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.example.demo.constant.Constant;
import com.example.demo.dto.location.Country;
import com.example.demo.model.DataResponse;
import com.example.demo.service.LocationService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class LocationServiceImpl implements LocationService {
	
	@Override
	public DataResponse getAllCountryAndCity() {
		try {
			Country[] countries = new ObjectMapper().readValue(new FileInputStream(Constant.COUNTRY_AND_CITY_DIRECTORY), Country[].class);
			return new DataResponse(countries);
		} catch (IOException e) {
			e.printStackTrace();
			return new DataResponse(Constant.FAILED, null, Constant.FAILED_CODE, null);
		}
	}

	@Override
	public DataResponse getVietnamLocation() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode data = mapper.readTree(new FileInputStream(Constant.VIETNAM_REGION)).get("data");
			return new DataResponse(data);
		} catch (IOException e) {
			e.printStackTrace();
			return new DataResponse(Constant.FAILED, null, Constant.FAILED_CODE, null);
		}
	}

}
