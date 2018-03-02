package jp.co.realsys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.realsys.dao.UserDao;
import jp.co.realsys.dao.UserMapper;
import jp.co.realsys.error.TaskException;
import jp.co.realsys.model.User;
import jp.co.realsys.model.UserModel;
import jp.co.realsys.service.UsersInfoService;

@Service("usersInfoService") 
public class UsersInfoServiceImpl implements UsersInfoService {
	
	@Autowired
	private UserMapper userMapper;
	
	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	public boolean doCheckUser(User model) throws TaskException {
		
		try {
			User userInfo = userMapper.getUser(model);
			
			if (userInfo == null) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			throw new TaskException(e);
		}
	}



	
}
