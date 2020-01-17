package com.bankapp.restapi.kindedbankrestapi.common;


import com.bankapp.restapi.kindedbankrestapi.enums.Currency;

import static com.bankapp.restapi.kindedbankrestapi.enums.Currency.*;

/**
 * @project spring-bank-app
 * @autor tejnal on 2020-01-14
 */
public class CurrencyUtils {

    public static Currency convertStringToCurrency (String currency) {
        switch (currency.toLowerCase()) {
            case "swedishkrona":
                return SWEDISHKRONA;
            case "pound":
                return POUND;
            default:
                return EURO;

        }
    }
}
