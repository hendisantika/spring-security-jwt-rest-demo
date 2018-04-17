package com.hendisantika.jwt.controller;

import com.hendisantika.jwt.model.Quote;
import com.hendisantika.jwt.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-security-jwt-rest-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 18/04/18
 * Time: 06.49
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/quotes")
public class QuoteController {

    @Autowired
    private QuoteService quoteService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Quote> getQuotes() {
        return quoteService.findAllQuotes();
    }
}
