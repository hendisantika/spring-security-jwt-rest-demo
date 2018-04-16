package com.hendisantika.jwt.security.repository;

import com.hendisantika.jwt.model.Account;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-security-jwt-rest-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 17/04/18
 * Time: 06.23
 * To change this template use File | Settings | File Templates.
 */
public interface AccountRepository {
    Account findByUsername(String username);
}
