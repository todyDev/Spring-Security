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
		
		log.debug("loadUserByUsername ::::::: 2");
		
		CustomUserDetails user = userAuthDAO.getUserById(username);
		
		if(user==null) {
			log.debug("no user :::::::: AuthenticationProvider");
			throw new UsernameNotFoundException(username);
		}

		return user;
	}

}
