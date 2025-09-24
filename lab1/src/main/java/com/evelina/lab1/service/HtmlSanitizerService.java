package com.evelina.lab1.service;

import org.springframework.stereotype.Service;
import org.owasp.html.PolicyFactory;
import org.owasp.html.Sanitizers;

@Service
public class HtmlSanitizerService {

    private static final PolicyFactory POLICY = Sanitizers.FORMATTING.and(Sanitizers.LINKS);

    public String sanitize(String input) {
        if (input == null) {
            return null;
        }
        return POLICY.sanitize(input);
    }
}