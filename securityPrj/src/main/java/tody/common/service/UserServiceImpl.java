package tody.common.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import tody.common.dao.UserAuthDAO;

@Service("userSer")
public class UserServiceImpl implements UserService {
	
	@Resource(name="userAuthDAO")
	private UserAuthDAO userDAO;

	@Override
	public void countFailure(String username) {
		userDAO.updateFailureCount(username);
	}

	@Override
	public int checkFailureCount(String username) {
		return userDAO.checkFailureCount(username);
	}

	@Override
	public void disabledUsername(String username) {
		userDAO.updateDisabled(username);
	}

}
