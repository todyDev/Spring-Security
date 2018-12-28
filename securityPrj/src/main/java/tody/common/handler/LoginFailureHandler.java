package tody.common.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import tody.common.util.MessageUtils;

public class LoginFailureHandler implements AuthenticationFailureHandler {
	
	private String loginidname;
	private String loginpwdname;
	private String errormsgname;
	private String defaultFailureUrl;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {
		
		String errormsg = null;
		
		if(exception instanceof BadCredentialsException) {
			errormsg = MessageUtils.getMessage("error.BadCredentials");
		} else if(exception instanceof InternalAuthenticationServiceException) {
			errormsg = MessageUtils.getMessage("error.BadCredentials");
		} else if(exception instanceof DisabledException) {
			errormsg = MessageUtils.getMessage("error.Disaled");
		} else if(exception instanceof CredentialsExpiredException) {
			errormsg = MessageUtils.getMessage("error.CredentialsExpired");
		}
		
		request.setAttribute("ID", request.getParameter("loginId"));
		request.setAttribute("PASSWORD", request.getParameter("loginPwd"));
		request.setAttribute("ERRORMSG", errormsg);
		request.getRequestDispatcher("/secu/loginPage?error").forward(request, response);
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
