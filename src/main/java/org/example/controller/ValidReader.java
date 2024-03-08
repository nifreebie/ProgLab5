package org.example.controller;

import org.example.model.*;
import org.example.validation.ValidationException;
import org.example.validation.Validator;
import org.example.validation.rules.*;

import java.util.List;
import java.util.Scanner;

public class ValidReader {
    private static Scanner sc = new Scanner(System.in);

    public static String readName() {
        System.out.println("Введите имя:");
        return readValidValue();
    }

    public static Integer readCoordinateX() {
        System.out.println("Введите координату x:");
        return Integer.parseInt(readValidValue(List.of(new MinRule(-497), new IntRule())));

    }

    public static Float readCoordinateY() {
        System.out.println("Введите координату y:");
        return Float.parseFloat(readValidValue(List.of(new MaxRule(745f), new FloatRule())));
    }

    public static int readPrice() {
        System.out.println("Введите цену:");
        return Integer.parseInt(readValidValue(List.of(new MinRule(1), new IntRule())));
    }

    public static String readPartNumber() {
        System.out.println("Введите partNumber:");
        return readValidValue(List.of(new StringLengthRule(74)));
    }

    public static UnitOfMeasure readUnitOfMeasure() {
        System.out.println("Выберите единицу измерения:");
        for (int i = 0; i < UnitOfMeasure.values().length; i++) {
            System.out.println(" • " + i + " - " + UnitOfMeasure.values()[i]);
        }
        String uofm = readValidValue(List.of(new IntRule(), new EnumRule(UnitOfMeasure.values())), false);
        return UnitOfMeasure.values()[Integer.parseInt(uofm)];

    }

    public static Long readEmployeesCount() {
        System.out.println("Введите количесство сотрдуников:");
        return Long.parseLong(readValidValue(List.of(new MinRule(1), new LongRule())));
    }

    public static OrganizationType readOrganizationType() {
        System.out.println("Выберите тип организации:");
        for (int i = 0; i < OrganizationType.values().length; i++) {
            System.out.println(" • " + i + " - " + OrganizationType.values()[i]);
        }
        String ot = readValidValue(List.of(new IntRule(), new EnumRule(OrganizationType.values())), false);
        return OrganizationType.values()[Integer.parseInt(ot)];
    }

    public static Address readAddress() {
        System.out.println("Введите адрес:");
        String street = readValidValue(List.of(), true);
        return new Address(street);
    }

    public static Coordinates readCoordinates() {
        Integer x = ValidReader.readCoordinateX();
        Float y = ValidReader.readCoordinateY();
        return new Coordinates(x, y);

    }

    public static String readOrganizationName() {
        System.out.println("Введите имя организации:");
        return readValidValue();
    }

    public static Organization readOrganization() {
        String orgName = readOrganizationName();
        Long emCount = readEmployeesCount();
        OrganizationType orgType = readOrganizationType();
        Address address = readAddress();
        return new Organization(orgName, emCount, orgType, address);
    }

    private static String readValidValue(List<Rule> rules, boolean nullable) {
        while (true) {
            String input = sc.nextLine().trim().toLowerCase();
            if (nullable && input.isBlank()) {
                return null;
            }
            try {
                Validator.validate(input, rules);
                return input;
            } catch (ValidationException e) {
                for (String errorMsg : e.getErrors()) {
                    System.out.println(errorMsg);
                }
            }
        }

    }

    private static String readValidValue(List<Rule> rules) {
        return readValidValue(rules, false);
    }

    private static String readValidValue() {
        return readValidValue(List.of(), false);
    }

}
