package com.example.usersdemo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// DTO = shu byeb3at el client lamma ya3mol POST aw PUT.
// "record" = class sghir bi Java, Java btektob el constructor w el getters 3annak.
public record UserRequest(
        @NotBlank String name,
        @NotBlank @Email String email,
        @NotBlank @Size(min = 6) String password
) {
}
