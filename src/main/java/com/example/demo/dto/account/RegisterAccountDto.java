package com.example.demo.dto.account;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterAccountDto {
	@Length(max = 12, min = 9)
	private String phoneNumber;
	
	@NotNull
	@NotEmpty
	private String password;
	
	@Pattern(message = "Email is invalid", regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
	@NotNull
	@NotEmpty
	private String email;
		
	private String cityId;
	private String districtId;
	private String wardId;
	private String detailLocation;
}
