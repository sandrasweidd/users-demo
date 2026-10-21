package com.example.usersdemo.dto;

import com.example.usersdemo.entity.User;
import java.time.LocalDateTime;

// DTO = shu mnraje3 lal client.
// ENCAPSULATION: ma fi password hon, fa el password ma bitla3 abadan bel API.
public record UserResponse(
        Long id,
        String name,
        String email,
        LocalDateTime createdAt
) {
    // Bt7awwel el Entity la DTO
    public static UserResponse from(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreatedAt()
        );
    }
}
