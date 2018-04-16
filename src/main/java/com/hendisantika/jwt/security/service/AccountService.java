package com.hendisantika.jwt.security.service;

import com.hendisantika.jwt.model.Account;
import com.hendisantika.jwt.security.repository.AccountRepository;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

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
@Service("userDetailsService")
public class AccountService implements UserDetailsService {

    private final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();
    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Fetch the account corresponding to the given username
        Account account = accountRepository.findByUsername(username);

        // If the account doesn't exist
        if (account == null) {
            throw new UsernameNotFoundException("User " + username + " not found");
        }

        // User(username, password, enabled, accountNonExpired, credentialsNotExpired, accountNonLocked, authorities)
        User user = new User(account.getUsername(), account.getPassword(), account.isEnabled(), true, true, true, emptyList());

        detailsChecker.check(user);

        return user;
    }

}