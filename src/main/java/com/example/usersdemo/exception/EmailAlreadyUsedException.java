package com.example.usersdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// INHERITANCE kamen: exception tenye, nafs el fekra. 409 = Conflict
@ResponseStatus(HttpStatus.CONFLICT)
public class EmailAlreadyUsedException extends RuntimeException {
    public EmailAlreadyUsedException(String email) {
        super("El email " + email + " mesta3mal");
    }
}
