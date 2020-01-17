package com.bankapp.restapi.kindedbankrestapi.response;

/**
 * @project kinded-bank-restapi
 * @autor tejnal on 2020-01-17
 */
public interface ErrorHandling {

    static String DEFAULT_MSG_NAME_FIELD = "message";
    static String DEFAULT_MSG_TITLE_FIELD = "title";
    static String DEFAULT_MSG_TITLE_VALUE = "Internal Server Error";
    static String DEFAULT_MSG_NAME_VALUE = "The server encountered an unexpected condition which prevented it from fulfilling the request.";
    static String RESOURCE_NOT_FOUND_MSG = "The resource requested is not found. Please check your resource ID.";

    public void setSuccess(boolean success);

    public void setSuccess(boolean success, String title, String msg);
}
