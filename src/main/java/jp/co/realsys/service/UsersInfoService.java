package jp.co.realsys.service;

import jp.co.realsys.error.TaskException;
import jp.co.realsys.model.User;

public interface UsersInfoService {

	public boolean doCheckUser(User model) throws TaskException ;
}
