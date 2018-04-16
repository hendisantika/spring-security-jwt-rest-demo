package com.hendisantika.jwt.model;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-security-jwt-rest-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 17/04/18
 * Time: 06.18
 * To change this template use File | Settings | File Templates.
 */
public class Quote {
    private String author;
    private String sentence;

    public Quote() {
    }

    public Quote(String author, String sentence) {
        this.author = author;
        this.sentence = sentence;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }
}
