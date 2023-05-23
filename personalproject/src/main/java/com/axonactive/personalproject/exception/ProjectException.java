package com.axonactive.personalproject.exception;

import org.springframework.http.HttpStatus;

public class ProjectException {
    private static final String ACCOUNT_NOT_FOUND_MSG_KEY = "AccountNotExisted";
    private static final String ACCOUNT_NOT_FOUND_MSG = "Account Not Found";
    private static final String HOUSE_NOT_FOUND_MSG_KEY = "HouseNotExisted";
    private static final String HOUSE_NOT_FOUND_MSG = "House Not Found";
    private static final String ODD_NOT_FOUND_MSG_KEY = "OddNotExisted";
    private static final String ODD_NOT_FOUND_MSG = "Odd Not Found";
    private static final String ODD_TYPE_NOT_FOUND_MSG_KEY = "OddTypeNotExisted";
    private static final String ODD_TYPE_NOT_FOUND_MSG = "Odd Type Not Found";
    private static final String ASSIGN_NOT_FOUND_MSG_KEY = "AssignNotExisted";
    private static final String ASSIGN_NOT_FOUND_MSG = "Assign Not Found";
    private static final String INVOICE_NOT_FOUND_MSG_KEY = "InvoiceNotExisted";
    private static final String INVOICE_NOT_FOUND_MSG = "Invoice Not Found";
    private static final String INVOICE_DETAIL_NOT_FOUND_MSG_KEY = "InvoiceDetailNotExisted";
    private static final String INVOICE_DETAIL_NOT_FOUND_MSG = "Invoice Detail Not Found";
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
    public static ResponseException InvoiceNotFound(){
        return notFound(INVOICE_NOT_FOUND_MSG_KEY,INVOICE_NOT_FOUND_MSG);
    }
    public static ResponseException InvoiceDetailNotFound(){
        return notFound(INVOICE_DETAIL_NOT_FOUND_MSG_KEY,INVOICE_DETAIL_NOT_FOUND_MSG);
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
    public static ResponseException houseNotFound(){
        return notFound(HOUSE_NOT_FOUND_MSG_KEY,HOUSE_NOT_FOUND_MSG);
    }
    public static ResponseException OddNotFound(){
        return notFound(ODD_NOT_FOUND_MSG_KEY,ODD_NOT_FOUND_MSG);
    }

    public static ResponseException OddTypeNotFound(){
        return notFound(ODD_TYPE_NOT_FOUND_MSG_KEY,ODD_TYPE_NOT_FOUND_MSG);
    }
}
