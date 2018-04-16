package com.hendisantika.jwt.security;

import com.hendisantika.jwt.security.repository.AccountRepositoryImpl;
import com.hendisantika.jwt.security.service.AccountService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Date;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-security-jwt-rest-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 17/04/18
 * Time: 06.22
 * To change this template use File | Settings | File Templates.
 */
public class TokenHandler {
    final public String TOKEN_PREFIX = "Bearer";            // the prefix of the token in the http header
    final public String HEADER_STRING = "Authorization";    // the http header containing the prexif + the token
    final long EXPIRATIONTIME = 15 * 60 * 1000;        // 15 minutes
    final String SECRET = "ThisIsASecret";            // private key, better read it from an external file
    private UserDetailsService userDetailsService = new AccountService(new AccountRepositoryImpl());

    /**
     * Generate a token from the username.
     *
     * @param username The subject from which generate the token.
     * @return The generated token.
     */
    public String build(String username) {

        Date now = new Date();

        String JWT = Jwts.builder()
                .setId(UUID.randomUUID().toString())
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                //.compressWith(CompressionCodecs.DEFLATE) // uncomment to enable token compression
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();

        return JWT;

    }

    /**
     * Parse a token and extract the subject (username).
     *
     * @param token A token to parse.
     * @return The subject (username) of the token.
     */
    public String parse(String token) {

        String username = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                .getBody()
                .getSubject();

        return userDetailsService.loadUserByUsername(username).getUsername();

    }
}
