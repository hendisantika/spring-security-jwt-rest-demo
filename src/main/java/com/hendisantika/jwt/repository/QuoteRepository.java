package com.hendisantika.jwt.repository;

import com.hendisantika.jwt.model.Quote;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-security-jwt-rest-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 17/04/18
 * Time: 06.19
 * To change this template use File | Settings | File Templates.
 */
public interface QuoteRepository {
    Collection<Quote> findAllQuotes();
}
