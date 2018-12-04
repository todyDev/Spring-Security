package tody.common.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import tody.common.dao.UserAuthDAO;
import tody.common.vo.CustomUserDetails;

public class CustomUserDetailsService implements UserDetailsService {
	
	Logger log = Logger.getLogger(getClass());
	
	@Autowired
	private UserAuthDAO userAuthDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		CustomUserDetails user = userAuthDAO.getUserById(username);
		
		log.debug("loadUserByUsername ::::::: 2");
		
		if(user==null) {
			throw new UsernameNotFoundException(username);
		}
		return user;
	}
	
	public void countFailure(String loginId) {
		userAuthDAO.updateFailureCount(loginId);
	}
	
	public int checkFailureCount(String loginId) {
		return userAuthDAO.checkFailureCount(loginId);
	}

}
