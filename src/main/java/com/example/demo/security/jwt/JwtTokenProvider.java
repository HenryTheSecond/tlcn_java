package com.example.demo.security.jwt;

import java.util.Date;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.GrantedAuthority;

import com.auth0.jwt.JWT;
import com.example.demo.constant.Constant;
import com.example.demo.security.model.ApplicationUserDetails;

public class JwtTokenProvider {
	public static String generateAccessToken(ApplicationUserDetails account, HttpServletRequest request) {
		Date now = new Date();
		Date expireDate = new Date(now.getTime() + Constant.JWT_ACCESS_TOKEN_EXPIRATION);
		return JWT.create()
				.withSubject(account.getUsername())
				.withExpiresAt(expireDate)
				.withIssuer(request.getRequestURL().toString())
				.withClaim("roles", account.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.sign(Constant.JWT_ALGORITHM);

	}
}
