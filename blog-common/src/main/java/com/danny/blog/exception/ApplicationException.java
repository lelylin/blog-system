package com.danny.blog.exception;

/**
 * Created by Danny on 2019/1/24
 */
public class ApplicationException extends RuntimeException {

    public ApplicationException() {
        super();
    }

    public ApplicationException(String message) {
        super(message);
    }
}
