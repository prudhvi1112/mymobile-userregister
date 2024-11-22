package com.userregister.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userregister.entity.UserData;



public interface UserDetailsDao extends JpaRepository<UserData, String>
{
	
	UserData findByUserEmail(String userEmail);

}
