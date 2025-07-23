package com.payticket.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BasicResponse<T> {
    private int code;
    private String message;
    private T data;

    public BasicResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BasicResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BasicResponse() {
    }
}
