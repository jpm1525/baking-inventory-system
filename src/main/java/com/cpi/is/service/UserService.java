package com.cpi.is.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.cpi.is.entity.SessionEntity;
import com.cpi.is.entity.UserEntity;

public interface UserService {


	//List<UserEntity> getData() throws Exception;
	UserEntity authenticate(HttpServletRequest request) throws Exception;
	void saveSession(HttpServletRequest request) throws Exception;
	SessionEntity validateSession(HttpServletRequest request) throws Exception;
	void deleteSession(HttpServletRequest request) throws Exception;
	
}
