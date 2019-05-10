package com.yarusprog.wic.service;

public interface EmailService {
    void sendSimpleMessage(final String to, final String subject, final String text);
}
