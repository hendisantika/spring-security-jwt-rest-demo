package com.hendisantika.jwt.service;

import com.hendisantika.jwt.model.Quote;
import com.hendisantika.jwt.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
@Service("quoteService")
public class QuoteServiceImpl implements QuoteService {

    @Autowired
    private QuoteRepository quoteRepository;

    @Override
    public List<Quote> findAllQuotes() {
        List<Quote> quotes = new ArrayList<>(quoteRepository.findAllQuotes());
        return quotes;
    }

}