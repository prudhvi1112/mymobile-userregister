package com.userregister.service;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.userregister.dto.UserAddedResponse;
import com.userregister.dto.UserDataDto;
import com.userregister.entity.UserData;
import com.userregister.exception.InvaildUserException;
import com.userregister.exception.UserIdOrEmailAlreadyExistsException;
import com.userregister.exception.UserNotFoundException;
import com.userregister.repo.UserDetailsDao;

@Service
public class UserRegisterService {

	@Autowired
	private UserDetailsDao userDetailsDao;

	@Autowired
	private ModelMapper mapper;

	@Transactional
	public UserAddedResponse addUser(UserDataDto userDataDto) {
		UserData userData = mapper.map(userDataDto, UserData.class);
		UserData userEmail = userDetailsDao.findByUserEmail(userData.getUserEmail());

		UserData userDetails = userDetailsDao.findById(userData.getUserId()).orElse(null);
		if (userEmail == null && userDetails == null) {

			userData.setUserRegsiterDate(LocalDateTime.now());
			userData.setUserLastLoginIn(LocalDateTime.now());
			userDetailsDao.save(userData);
			UserAddedResponse response = new UserAddedResponse(userData.getUserId(), userData.getUserEmail());
			return response;
		} else {
			throw new UserIdOrEmailAlreadyExistsException("User Id Or Email Already Exist");
		}
	}

	public UserDataDto getVendor(String vendor) {

		UserData userData = userDetailsDao.findById(vendor)
				.orElseThrow(() -> new UserNotFoundException("User Not Found With Id : " + vendor));

		if (userData.getUserRole().equals("vendor")) {
			return mapper.map(userData, UserDataDto.class);
		} else {
			throw new InvaildUserException("Invalid Vendor With Vendor Id : " + vendor);
		}

	}

}
