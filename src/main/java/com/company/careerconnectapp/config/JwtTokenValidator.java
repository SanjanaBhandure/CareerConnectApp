package com.company.careerconnectapp.config;


import java.io.IOException;
import javax.crypto.SecretKey;

import com.company.careerconnectapp.model.User;
import com.company.careerconnectapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtTokenValidator extends OncePerRequestFilter {

	@Autowired
	UserRepository userRepository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String jwt = request.getHeader(JwtConstant.JWT_HEADER);
		System.out.println("jwt ------ "+jwt);
		if(jwt!=null) {
			jwt=jwt.substring(7);
			System.out.println("jwt ------ "+jwt);
			try {
				
				SecretKey key= Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes());
				
				Claims claims=Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody();
				
				String email=String.valueOf(claims.get("email"));

				User user = userRepository.findDistinctByEmail(email);

				request.setAttribute("userId", user.getId());
				
			} catch (Exception e) {
				throw new BadCredentialsException("invalid token...");
			}
		}
		filterChain.doFilter(request, response);
		
	}

}
