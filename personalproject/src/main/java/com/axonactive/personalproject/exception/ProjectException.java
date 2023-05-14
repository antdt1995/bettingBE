package com.axonactive.personalproject.exception;

import org.springframework.http.HttpStatus;

public class ProjectException {
    private static final String ACCOUNT_NOT_FOUND_MSG_KEY = "AccountNotExisted";
    private static final String ACCOUNT_NOT_FOUND_MSG = "Account Not Found";
    private static final String ASSIGN_NOT_FOUND_MSG_KEY = "AssignNotExisted";
    private static final String ASSIGN_NOT_FOUND_MSG = "Assign Not Found";
    private static final String BILLING_NOT_FOUND_MSG_KEY = "BillingNotExisted";
    private static final String BILLING_NOT_FOUND_MSG = "Billing Not Found";
    private static final String BILLING_DETAIL_NOT_FOUND_MSG_KEY = "BillingDetailNotExisted";
    private static final String BILLING_DETAIL_NOT_FOUND_MSG = "Billing Detail Not Found";
    private static final String CUSTOMER_NOT_FOUND_MSG_KEY = "CustomerNotExisted";
    private static final String CUSTOMER_NOT_FOUND_MSG = "Customer Not Found";
    private static final String FOOTBALL_TEAM_NOT_FOUND_MSG_KEY = "FootballTeamNotExisted";
    private static final String FOOTBALL_TEAM_NOT_FOUND_MSG = "Football Team Not Found";
    private static final String FOOTBALL_MATCH_NOT_FOUND_MSG_KEY = "FootballMatchNotExisted";
    private static final String FOOTBALL_MATCH_NOT_FOUND_MSG = "Football Match Not Found";
    public static ResponseException notFound(String messageKey, String message) {
        return new ResponseException(messageKey, message, HttpStatus.NOT_FOUND);
    }

    public static ResponseException badRequest(String messageKey, String message) {
        return new ResponseException(messageKey, message, HttpStatus.BAD_REQUEST);
    }

    public static ResponseException internalServerError(String messageKey, String message) {
        return new ResponseException(messageKey, message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    public static ResponseException AccountNotFound() {
        return notFound(ACCOUNT_NOT_FOUND_MSG_KEY,ACCOUNT_NOT_FOUND_MSG);
    }
    public static ResponseException AssignNotFound(){
        return notFound(ASSIGN_NOT_FOUND_MSG_KEY,ASSIGN_NOT_FOUND_MSG);
    }
    public static ResponseException BillingNotFound(){
        return notFound(BILLING_NOT_FOUND_MSG_KEY,BILLING_NOT_FOUND_MSG);
    }
    public static ResponseException BillingDetailNotFound(){
        return notFound(BILLING_DETAIL_NOT_FOUND_MSG_KEY,BILLING_DETAIL_NOT_FOUND_MSG);
    }
    public static ResponseException CustomerNotFound(){
        return notFound(CUSTOMER_NOT_FOUND_MSG_KEY,CUSTOMER_NOT_FOUND_MSG);
    }
    public static ResponseException footballTeamNotFound(){
        return notFound(FOOTBALL_TEAM_NOT_FOUND_MSG_KEY, FOOTBALL_TEAM_NOT_FOUND_MSG);
    }
    public static ResponseException footballMatchNotFound(){
        return notFound(FOOTBALL_MATCH_NOT_FOUND_MSG_KEY, FOOTBALL_MATCH_NOT_FOUND_MSG);
    }
}
