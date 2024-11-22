package com.userregister.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userregister.dto.UserAddedResponse;
import com.userregister.dto.UserDataDto;
import com.userregister.service.UserRegisterService;

import jakarta.validation.Valid;

@RestController
public class UserRegisterController {
	@Autowired
	private UserRegisterService userRegisterService;

	@PostMapping("/register")
	public ResponseEntity<UserAddedResponse> addUser(@Valid @RequestBody UserDataDto userDataDto) {
		return new ResponseEntity<>(userRegisterService.addUser(userDataDto), HttpStatus.CREATED);
	}

	
	@GetMapping("/getVendor/{id}")
	public ResponseEntity<UserDataDto> getUserData(@PathVariable("id") String vendorId)
	{
		return new ResponseEntity<>(userRegisterService.getVendor(vendorId), HttpStatus.OK);
		
	}
	
	
	
}
