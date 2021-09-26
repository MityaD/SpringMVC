package com.yakut.spring.exception;

public class NoAddressTableException extends Exception {
    public NoAddressTableException(Long id) {
        System.out.println("Нет адреса с ID: " + id);
    }
}
