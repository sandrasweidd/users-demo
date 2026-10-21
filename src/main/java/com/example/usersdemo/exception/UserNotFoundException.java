package com.example.usersdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// INHERITANCE: extends RuntimeException => howe exception w btewras kel shi menno.
// @ResponseStatus: eza tla3 hayda el error, Spring biraje3 404 lal client.
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("Ma fi user bel id " + id);
    }
}
