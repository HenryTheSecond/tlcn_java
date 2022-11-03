package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.account.RegisterAccountDto;
import com.example.demo.model.DataResponse;
import com.example.demo.service.AccountService;

@RestController
@RequestMapping("/account")
@Validated
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/user/register")
	public DataResponse userRegister(@RequestBody @Valid RegisterAccountDto registerAccountDto) {
		return accountService.registerUser(registerAccountDto);
	}
}
