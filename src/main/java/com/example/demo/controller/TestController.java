package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.DataResponse;
import com.example.demo.service.LocationService;
import com.example.demo.service.impl.LocationServiceImpl;

@RestController
@RequestMapping("/test")
public class TestController {
	@GetMapping
	public DataResponse test(){
		LocationService service = new LocationServiceImpl();
		return service.getVietnamLocation();
	}
	
	@PostMapping
	public ResponseEntity<?> testPost(){
		return ResponseEntity.ok("post good");
	}
}
