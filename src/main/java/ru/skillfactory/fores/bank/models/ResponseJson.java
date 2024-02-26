package ru.skillfactory.fores.bank.models;

import lombok.Data;

@Data
public class ResponseJson {
    private final int value;
    private String message;

    public ResponseJson(int value) {
        this.value = value;
    }

    public ResponseJson(int value, String message) {
        this.value = value;
        this.message = message;
    }
}