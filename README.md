# Spring Boot REST Application + Spring Security with JWT

A demo to test Spring Security and JWT for a RESTful application

#### Usage

To login, add the following code to the body of a GET request at '/login': `{"username":"user","password":"password"}`

To access the protected resource '/quotes', add to the Authentication header of the request the token obtained by logging in:

`Authentication: Bearer XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX`

#### Implementation

Spring Security is configured in `com.hendisantika.jwt.config` package:

* `WebSecurityConfig` defines the policy to access resources, filters for login and authentication, a fake user in memory.

Authentication, Login and JWT are handled in `com.hendisantika.jwt.security` package:

* `JWTAuthenticationEntryPoint` returns a 401 status code if token authentication fails (whatever the reason)
* `JWTLoginFilter is used` to log in users and generate a token.
* `JWTAuthenticationFilter` is used to authenticate (token verification) users when trying to access protected resources.
* `TokenAuthenticationService` provides methods to generate tokens, to verify their validity.
* `TokenHandler` is a utility class implementing methods to build and parse tokens.

Resources

This demo has been inspired by the following guides and tutorials:

* [Spring Security Architecture](https://spring.io/guides/topicals/spring-security-architecture/)
* [Securing Spring Boot with JWTs](https://auth0.com/blog/securing-spring-boot-with-jwts/)
* [Stateless Authentication with Spring Security and JWT](http://technicalrex.com/2015/02/20/stateless-authentication-with-spring-security-and-jwt)
* [Securing REST APIs With Spring Boot](http://ryanjbaxter.com/2015/01/06/securing-rest-apis-with-spring-boot/)
* [SpringSecurity : Authenticate User with Custom UserDetailsService](http://www.ekiras.com/2016/04/authenticate-user-with-custom-user-details-service-in-spring-security.html)
* [REST Security with JWT using Java and Spring Security](https://www.toptal.com/java/rest-security-with-jwt-spring-security-and-java)

Useful Readings

    JSON Web Tokens
