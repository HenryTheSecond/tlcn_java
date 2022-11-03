package com.example.demo.dto.location;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country {
	private String countryShortCode;
	private String countryName;
	
	private List<Region> regions;
}
