package org.example.validation;

import java.util.List;

public class ValidationException extends RuntimeException{
    private final List<String> errors;

    public ValidationException(List<String> error) {
        this.errors = error;
    }
    public List<String> getErrors(){
        return errors;
    }
}
