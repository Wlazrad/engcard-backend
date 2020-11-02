package com.wlazrad.pdf;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomException extends RuntimeException {

    private String code;
    private String message;

    public CustomException(String code) {
        super();
        this.code = code;
    }

    public CustomException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
