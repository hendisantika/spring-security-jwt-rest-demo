package com.hendisantika.jwt.security.service;

import com.hendisantika.jwt.security.TokenHandler;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static java.util.Collections.emptyList;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-security-jwt-rest-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 17/04/18
 * Time: 06.28
 * To change this template use File | Settings | File Templates.
 */
@Service
public class TokenAuthenticationServiceImpl implements TokenAuthenticationService {

    private TokenHandler tokenHandler = new TokenHandler();

    /**
     * When a user successfully logs into the application, create a token for that user.
     *
     * @param res      An http response that will be filled with an 'Authentication' header containing the token.
     * @param username The username mapped to the user.
     */
    @Override
    public void addAuthentication(HttpServletResponse res, Authentication authentication) {

        String user = authentication.getName();

        String JWT = tokenHandler.build(user);

        res.addHeader(tokenHandler.HEADER_STRING, tokenHandler.TOKEN_PREFIX + " " + JWT);
    }

    /**
     * The JWTAuthenticationFilter calls this method to verify the user authentication.
     * If the token is not valid, the authentication fails and the request will be refused.
     *
     * @param request An http request that will be check for authentication token to verify.
     * @return
     */
    @Override
    public Authentication getAuthentication(HttpServletRequest request) {

        String token = request.getHeader(tokenHandler.HEADER_STRING);

        if (token != null && token.startsWith(tokenHandler.TOKEN_PREFIX)) {
            // Parse the token.
            String user = null;

            try {
                user = tokenHandler.parse(token);
            } catch (ExpiredJwtException e) {
                e.printStackTrace();
            } catch (UnsupportedJwtException e) {
                e.printStackTrace();
            } catch (MalformedJwtException e) {
                e.printStackTrace();
            } catch (SignatureException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }

            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, emptyList());
            } else {
                return null;
            }

        }

        return null;

    }

}