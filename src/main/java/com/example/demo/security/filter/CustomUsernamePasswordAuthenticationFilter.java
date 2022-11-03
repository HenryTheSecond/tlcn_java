package com.example.demo.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.StringUtils;

import com.example.demo.constant.Constant;
import com.example.demo.dto.login.LoginRequest;
import com.example.demo.model.DataResponse;
import com.example.demo.security.jwt.JwtTokenProvider;
import com.example.demo.security.model.ApplicationUserDetails;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	private final AuthenticationManager authenticationManager;

	public CustomUsernamePasswordAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		System.out.println("AUTHENTICATE");
		ObjectMapper objectMapper = new ObjectMapper();
		LoginRequest loginRequest;
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		String errorMessage = "";
		try {
			loginRequest = objectMapper.readValue(request.getInputStream(), LoginRequest.class);
			String email = loginRequest.getEmail();
			String password = loginRequest.getPassword();
			if (StringUtils.hasText(email) && StringUtils.hasText(password)) {
				UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email,
						password);
				return authenticationManager.authenticate(authenticationToken);
			} else {
				errorMessage = Constant.EMAIL_OR_PASSWORD_MISSING;
			}
		} catch (DisabledException ex) {
			ex.printStackTrace();
			errorMessage = Constant.ACCOUNT_INACTIVE;
		} catch (BadCredentialsException ex) {
			ex.printStackTrace();
			errorMessage = Constant.EMAIL_OR_PASSWORD_INCORRECT;
		} catch (IOException e) {
			e.printStackTrace();
			errorMessage = Constant.BAD_REQUEST;
		}

		try {
			objectMapper.writeValue(response.getOutputStream(),
					new DataResponse(Constant.UNAUTHORIZED, Constant.UNAUTHORIZED_CODE, errorMessage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		ApplicationUserDetails user = (ApplicationUserDetails) authResult.getPrincipal();
		String accessToken = JwtTokenProvider.generateAccessToken(user, request);
		new ObjectMapper().writeValue(response.getOutputStream(), new DataResponse(accessToken));
	}

}
