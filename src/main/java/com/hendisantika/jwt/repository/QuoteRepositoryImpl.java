package com.hendisantika.jwt.repository;

import com.hendisantika.jwt.model.Quote;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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
@Repository("quoteRepository")
public class QuoteRepositoryImpl implements QuoteRepository {

    private Map<String, Quote> quotesMap = new HashMap<>();

    public QuoteRepositoryImpl() {
        Quote q1 = new Quote("Hermione Granger", "It's leviosa, not leviosar!");
        quotesMap.put("Hermione Granger", q1);
        Quote q2 = new Quote("Sheldon Cooper", "Bazinga!");
        quotesMap.put("Sheldon Cooper", q2);
        Quote q3 = new Quote("Gandalf The Grey", "You shall not pass!");
        quotesMap.put("Gandalf The Grey", q3);
    }

    @Override
    public Collection<Quote> findAllQuotes() {
        return quotesMap.values();
    }

}
