package org.example.validation.rules;

public class DoubleRule implements Rule {
    public boolean check(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public String errorMessage() {
        return "Поле должно быть числового типа!";
    }
}
