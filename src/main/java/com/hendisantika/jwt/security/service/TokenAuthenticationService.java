package com.hendisantika.jwt.security.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-security-jwt-rest-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 17/04/18
 * Time: 06.26
 * To change this template use File | Settings | File Templates.
 */
public interface TokenAuthenticationService {
    /**
     * When a user successfully logs into the application, create a token for that user.
     *
     * @param res An http response that will be filled with an 'Authentication' header containing the token.
     */
    void addAuthentication(HttpServletResponse res, Authentication authentication);

    /**
     * The JWTAuthenticationFilter calls this method to verify the user authentication.
     * If the token is not valid, the authentication fails and the request will be refused.
     *
     * @param request An http request that will be check for authentication token to verify.
     * @return
     */
    Authentication getAuthentication(HttpServletRequest request);
}
