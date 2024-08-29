package com.cpi.is.service;

import javax.servlet.http.HttpServletRequest;

import com.cpi.is.entity.SessionEntity;
import com.cpi.is.entity.UserEntity;

public interface UserService {

	UserEntity authenticate(HttpServletRequest request) throws Exception;
	void saveSession(HttpServletRequest request) throws Exception;
	SessionEntity validateSession(HttpServletRequest request) throws Exception;
	void deleteSession(HttpServletRequest request) throws Exception;
	
}
