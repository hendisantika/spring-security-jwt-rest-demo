package com.hendisantika.jwt.service;

import com.hendisantika.jwt.model.Quote;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-security-jwt-rest-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 17/04/18
 * Time: 06.20
 * To change this template use File | Settings | File Templates.
 */
public interface QuoteService {
    List<Quote> findAllQuotes();
}
