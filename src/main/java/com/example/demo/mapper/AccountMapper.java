package com.example.demo.mapper;

import org.mapstruct.Mapper;

import com.example.demo.dto.account.RegisterAccountDto;
import com.example.demo.entity.Account;

@Mapper(componentModel = "spring")
public interface AccountMapper {
	Account registerAccountDtoToEntity(RegisterAccountDto registerAccountDto);
}
