package com.userregister.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserAddedResponse 
{
	private String userId;
	private String userName;

}
