package com.wraith.exception;

/**
 * User: rowan.massey
 * Date: 03/04/13
 * Time: 22:17
 */
public class MoneyException extends RuntimeException {

    public MoneyException(String errorMessage) {
        super(errorMessage);
    }
}