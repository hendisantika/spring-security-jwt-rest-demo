package com.hendisantika.jwt.security.repository;

import com.hendisantika.jwt.model.Account;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-security-jwt-rest-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 17/04/18
 * Time: 06.24
 * To change this template use File | Settings | File Templates.
 */
@Repository("accountRepository")
public class AccountRepositoryImpl implements AccountRepository {

    private Map<String, Account> accountsMap = new HashMap<>();

    public AccountRepositoryImpl() {
        Account account = new Account("user", "password");
        accountsMap.put(account.getUsername(), account);
    }

    @Override
    public Account findByUsername(String username) {
        return accountsMap.get(username);
    }

}