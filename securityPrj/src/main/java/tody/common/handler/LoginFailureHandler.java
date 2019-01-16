package tody.common.handler;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;

import tody.common.service.UserService;
import tody.common.util.MessageUtils;

public class LoginFailureHandler implements AuthenticationFailureHandler {
	
	@Resource(name="userSer")
	private UserService userSer;
	
	private String loginidname;
	private String loginpwdname;
	private String errormsgname;
	private String defaultFailureUrl;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {
		
		String username = request.getParameter(loginidname);
		String password = request.getParameter(loginpwdname);
		String errormsg = null;
		
		if(exception instanceof BadCredentialsException) {
			loginFailureCount(username);
			errormsg = MessageUtils.getMessage("error.BadCredentials");
		} else if(exception instanceof InternalAuthenticationServiceException) {
			errormsg = MessageUtils.getMessage("error.BadCredentials");
		} else if(exception instanceof DisabledException) {
			errormsg = MessageUtils.getMessage("error.Disaled");
		} else if(exception instanceof CredentialsExpiredException) {
			errormsg = MessageUtils.getMessage("error.CredentialsExpired");
		} else if(exception instanceof SessionAuthenticationException) {
			errormsg = MessageUtils.getMessage("error.SessionAuthentication");
		}
		
		request.setAttribute(loginidname, username);
		request.setAttribute(loginpwdname, password);
		request.setAttribute(errormsgname, errormsg);
		request.getRequestDispatcher(defaultFailureUrl).forward(request, response);
	}
	
	protected void loginFailureCount(String username) {
		userSer.countFailure(username);
		int cnt = userSer.checkFailureCount(username);
		if(cnt==3) {
			userSer.disabledUsername(username);
		}
	}

	public String getLoginidname() {
		return loginidname;
	}

	public void setLoginidname(String loginidname) {
		this.loginidname = loginidname;
	}

	public String getLoginpwdname() {
		return loginpwdname;
	}

	public void setLoginpwdname(String loginpwdname) {
		this.loginpwdname = loginpwdname;
	}

	public String getErrormsgname() {
		return errormsgname;
	}

	public void setErrormsgname(String errormsgname) {
		this.errormsgname = errormsgname;
	}

	public String getDefaultFailureUrl() {
		return defaultFailureUrl;
	}

	public void setDefaultFailureUrl(String defaultFailureUrl) {
		this.defaultFailureUrl = defaultFailureUrl;
	}

}
