package tody.common.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class LoginFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {
		
		request.setAttribute("ID", request.getParameter("loginId"));
		request.setAttribute("PASSWORD", request.getParameter("loginPwd"));
		request.setAttribute("ERRORMSG",exception.getMessage());
		request.getRequestDispatcher("/secu/loginPage?error").forward(request, response);
	}

}
