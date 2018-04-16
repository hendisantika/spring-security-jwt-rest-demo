package com.hendisantika.jwt.security;

import com.hendisantika.jwt.security.service.TokenAuthenticationService;
import com.hendisantika.jwt.security.service.TokenAuthenticationServiceImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-security-jwt-rest-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 17/04/18
 * Time: 06.29
 * To change this template use File | Settings | File Templates.
 */
public class JWTAuthenticationFilter extends GenericFilterBean {

    private TokenAuthenticationService tokenAuthenticationService = new TokenAuthenticationServiceImpl();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        // Delegates authentication to the TokenAuthenticationService
        Authentication authentication = tokenAuthenticationService.getAuthentication((HttpServletRequest) request);

        // Apply the authentication to the SecurityContextHolder
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Go on processing the request
        filterChain.doFilter(request, response);

        // Clears the context from authentication
        SecurityContextHolder.getContext().setAuthentication(null);

    }

}