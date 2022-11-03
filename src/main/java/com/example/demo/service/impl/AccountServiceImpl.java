package com.example.demo.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.constant.Constant;
import com.example.demo.constant.Role;
import com.example.demo.constant.UserStatus;
import com.example.demo.dto.account.AccountResponse;
import com.example.demo.dto.account.RegisterAccountDto;
import com.example.demo.entity.Account;
import com.example.demo.exception.GeneralException;
import com.example.demo.mapper.AccountMapper;
import com.example.demo.model.DataResponse;
import com.example.demo.repository.AccountRepository;
import com.example.demo.service.AccountService;
import com.example.demo.service.LocationService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private AccountMapper accountMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoded;
	
	@Autowired
	private LocationService locationService;

	@Override
	public DataResponse registerUser(RegisterAccountDto registerAccountDto) {
		if(accountRepository.findByEmail(registerAccountDto.getEmail()).isPresent()) {
			throw new GeneralException("This email has already existed", Constant.FAILED_CODE);
		}
		registerAccountDto.setPassword( passwordEncoded.encode(registerAccountDto.getPassword()) );
		Account account = accountMapper.registerAccountDtoToEntity(registerAccountDto);
		account.setRole(Role.ROLE_USER);
		account.setStatus(UserStatus.INACTIVE);
		
		//Check account's address is valid
		String checkLocation = checkAccountAddress(account);
		if(checkLocation != null) {
			throw new GeneralException(checkLocation, Constant.NOT_FOUND_CODE);
		}
		
		//TODO
		return null;
	}
	
	private String checkAccountAddress(Account account){
		Map<String, String> validator = new HashMap<>();
		ArrayNode locationData = (ArrayNode) locationService.getVietnamLocation().getData();
		for(JsonNode cityNode: locationData) {
			if(cityNode.get("level1_id").asText().equals(account.getCityId())) {
				for(JsonNode districtNode: cityNode.get("level2s")) {
					if(districtNode.get("level2_id").asText().equals(account.getDistrictId())) {
						for(JsonNode wardNode: districtNode.get("level3s")) {
							if(wardNode.get("level3_id").asText().equals(account.getWardId())) {
								return null;
							}
						}
						return Constant.WARD_NOT_FOUND;
					}
				}
				return Constant.DISTRICT_NOT_FOUND;
			}
		}
		return Constant.CITY_NOT_FOUND;
	}
	
	
}
