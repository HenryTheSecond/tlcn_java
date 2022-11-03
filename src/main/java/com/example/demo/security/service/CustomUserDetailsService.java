package com.example.demo.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.constant.Constant;
import com.example.demo.entity.Account;
import com.example.demo.repository.AccountRepository;
import com.example.demo.security.model.ApplicationUserDetails;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Account account = accountRepository.findByEmail(email).orElseThrow(() -> new RuntimeException(Constant.NOT_FOUND));	
		return new ApplicationUserDetails(account);
	}

}
