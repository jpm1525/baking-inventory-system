package com.cpi.is.dao;

import com.cpi.is.entity.SessionEntity;
import com.cpi.is.entity.UserEntity;

public interface UserDAO {

	UserEntity authenticate(UserEntity user) throws Exception;
	void saveSession(SessionEntity userSession) throws Exception;
	UserEntity getUser(String username) throws Exception;
	SessionEntity validateSession(SessionEntity userSession) throws Exception;
	void deleteSession(SessionEntity userSession) throws Exception;
	
}
