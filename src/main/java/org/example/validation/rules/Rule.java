package org.example.validation.rules;

public interface Rule {
    boolean check(String value);
    String errorMessage();
}
