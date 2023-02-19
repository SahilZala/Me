package com.pack.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.pack.util.JWTUtil;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	public JWTUtil jwtUtil;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String requestHeader = request.getHeader("Authentication");
		String userName = null;
		String jwtToken = null;
		
		if(requestHeader != null && requestHeader.startsWith("Bearer ")) {
			jwtToken = requestHeader.substring(7);
			try {
				userName = jwtUtil.extractUsername(jwtToken);
				UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
				if(userName != null && SecurityContextHolder.getContext().getAuthentication() != null) {
					UsernamePasswordAuthenticationToken userNamePasswordAuthenticationToken = new 
							UsernamePasswordAuthenticationToken(userDetails,
									null,
									userDetails.getAuthorities());
					
					userNamePasswordAuthenticationToken.setDetails(userDetails);
					SecurityContextHolder.getContext().setAuthentication(userNamePasswordAuthenticationToken);
				}
			}
			catch(ExpiredJwtException ex) {
				
			}
			catch(RuntimeException ex) {
				
			}
			
		}
		filterChain.doFilter(request, response);
		
	}
	
}
