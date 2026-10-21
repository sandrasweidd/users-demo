package com.example.usersdemo.service;

import com.example.usersdemo.dto.UserRequest;
import com.example.usersdemo.dto.UserResponse;
import java.util.List;

// INTERFACE = el 3a2d (contract).
// Bi2oul "shu" lazem ya3mol el service, mesh "kif".
// El Controller byehki ma3 hayda, mesh ma3 el Impl.
public interface UserService {

    List<UserResponse> getAll();

    UserResponse getById(Long id);

    UserResponse create(UserRequest request);

    UserResponse update(Long id, UserRequest request);

    void delete(Long id);
}
