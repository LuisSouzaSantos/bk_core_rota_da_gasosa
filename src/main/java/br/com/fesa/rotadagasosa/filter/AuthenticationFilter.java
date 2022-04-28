package br.com.fesa.rotadagasosa.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.fesa.rotadagasosa.model.Login;
import br.com.fesa.rotadagasosa.service.LoginService;
import br.com.fesa.rotadagasosa.service.TokenService;

public class AuthenticationFilter extends OncePerRequestFilter {

	private TokenService tokenService;
	private LoginService loginService;
	
	public AuthenticationFilter(TokenService tokenService, LoginService loginService) {
		this.tokenService = tokenService;
		this.loginService = loginService;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = retrieveToken(request);
		
		if(tokenService.isTokenValid(token)) {
			authenticateClient(token);
		}
		
		filterChain.doFilter(request, response);
	}
	
	private void authenticateClient(String token) {
		String username = tokenService.getUsername(token);
		
		Login login = loginService.getByUsername(username);
		
		UsernamePasswordAuthenticationToken authenticationToken 
			= new UsernamePasswordAuthenticationToken(login, null, login.getAuthorities());
		
		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
	}
	
	
	private String retrieveToken(HttpServletRequest httpServletRequest) {
		String token = httpServletRequest.getHeader("Authorization");
		
		if(token == null || token.isEmpty() || !token.startsWith("Bearer ")) { return null; }
		
		return token.substring(7, token.length());
	}
	
}