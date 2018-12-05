package tody.common.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import tody.common.service.CustomUserDetailsService;

public class LoginFailureHandler implements AuthenticationFailureHandler {
	
	@Autowired
	private CustomUserDetailsService userDeSer;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {
		
		String loginId = request.getParameter("loginId");
		String msgerror = exception.getMessage();
		
		if(exception instanceof BadCredentialsException) {
			userDeSer.countFailure(loginId);	
			int cnt = userDeSer.checkFailureCount(loginId);
			
			if(cnt==3) {
				userDeSer.unenabledUsername(loginId);
			}
		}
		
		if(exception instanceof InternalAuthenticationServiceException) {
			msgerror="아이디나 비밀번호가 맞지 않습니다. 다시 확인해주세요.";
		}
		
		request.setAttribute("ID", request.getParameter("loginId"));
		request.setAttribute("PASSWORD", request.getParameter("loginPwd"));
		request.setAttribute("ERRORMSG", msgerror);
		request.getRequestDispatcher("/secu/loginPage?error").forward(request, response);
	}

}
