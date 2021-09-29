package com.sc.pioneers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.sc.pioneers.config.APISuccessPayload;
import com.sc.pioneers.entities.vo.AppUserLoginVO;
import com.sc.pioneers.entities.vo.AppUserRegisterVO;
import com.sc.pioneers.entities.vo.AppUserTokenVO;
import com.sc.pioneers.services.IAuthService;

@RestController
@CrossOrigin
public class AuthenticationController 
{
	@Autowired
	IAuthService authService;
	
	@PostMapping("/appusers")
	public ResponseEntity<APISuccessPayload> register(@RequestBody AppUserRegisterVO userVO)
	{
		authService.createAppUser(userVO);
		APISuccessPayload payload=new APISuccessPayload();
		HttpStatus status=HttpStatus.CREATED;
		payload.setBody("User created successfully");
		payload.setMessage("User created successfully");
		payload.setStatus(status.value());
		payload.setHttpStatus(String.valueOf(status));
		payload.setSuccess(true);
		payload.setException(false);
		
		
		ResponseEntity<APISuccessPayload> response=new ResponseEntity<APISuccessPayload>(payload,HttpStatus.CREATED);
		return response;
	}
	
	@PostMapping("/appusers/login")
	public ResponseEntity<APISuccessPayload> login(@RequestBody AppUserLoginVO loginVO)
	{
		AppUserTokenVO tokenVO=authService.login(loginVO);
		
		APISuccessPayload payload=new APISuccessPayload();
		HttpStatus status=HttpStatus.OK;
		payload.setBody(tokenVO);
		payload.setMessage("Login Successful");
		payload.setStatus(status.value());
		payload.setHttpStatus(String.valueOf(status));
		payload.setSuccess(true);
		payload.setException(false);
		
		
		ResponseEntity<APISuccessPayload> response=new ResponseEntity<APISuccessPayload>(payload,HttpStatus.CREATED);
		return response;
		
		
	}
	@PostMapping("/appusers/logout")
	public ResponseEntity<APISuccessPayload> logout(@RequestHeader("X-SCB-Username") String username,
																@RequestHeader("X-SCB-Token") String token)
	{
		AppUserTokenVO tokenVO=new AppUserTokenVO();
		tokenVO.setToken(token);
		tokenVO.setUsername(username);
		
		authService.logout(tokenVO);
		
		APISuccessPayload payload=new APISuccessPayload();
		HttpStatus status=HttpStatus.OK;
		payload.setBody("Logout Successful");
		payload.setMessage("Logout Successful");
		payload.setStatus(status.value());
		payload.setHttpStatus(String.valueOf(status));
		payload.setSuccess(true);
		payload.setException(false);
		
		ResponseEntity<APISuccessPayload> response=new ResponseEntity<APISuccessPayload>(payload,status);
		return response;
		
		
	}

}
