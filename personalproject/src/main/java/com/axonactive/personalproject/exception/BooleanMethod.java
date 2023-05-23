package com.axonactive.personalproject.exception;

public class BooleanMethod {
    public static boolean isAlpha(String input) {
        String pattern = "^[a-zA-Z]+$";
        return input.matches(pattern);
    }
    public static boolean isAlphanumeric(String input) {
        String pattern = "^[a-zA-Z0-9]+$";
        return input.matches(pattern);
    }
    public static boolean isAlphaOrNumberic(String input){
        String pattern = "^(?:[a-zA-Z]+|[0-9]+)$";
        return input.matches(pattern);
    }
    public static boolean isAlphaOrNumberOrSpecial(String input){
        String pattern = "^[a-zA-Z0-9!@#$%^&*()_+=\\-\\[\\]{}|\\\\:;\"'<>,.?/]+)$";
        return input.matches(pattern);
    }
    public static boolean isAlphanumericWithSpecial(String input) {
        String pattern = "^[a-zA-Z0-9\\p{Punct}]{6,}$";
        return input.matches(pattern);
    }
    public static boolean isNumberOnly(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }


}
