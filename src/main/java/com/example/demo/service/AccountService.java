package com.example.demo.service;

import com.example.demo.dto.account.RegisterAccountDto;
import com.example.demo.model.DataResponse;

public interface AccountService {
	public DataResponse registerUser(RegisterAccountDto registerAccountDto);
}
