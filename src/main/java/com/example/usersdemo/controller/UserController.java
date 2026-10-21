package com.example.usersdemo.controller;

import com.example.usersdemo.dto.UserRequest;
import com.example.usersdemo.dto.UserResponse;
import com.example.usersdemo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// El Controller byest2bel el HTTP requests w byeb3ata lal service.
@RestController
@RequestMapping("/api/users")
public class UserController {

    // POLYMORPHISM: el type howe el INTERFACE (UserService).
    // El Controller ma bya3ref eza wara fi UserServiceImpl aw ay implementation tenye.
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;   // Spring byeb3at UserServiceImpl hon
    }

    // GET /api/users
    @GetMapping
    public List<UserResponse> getAll() {
        return userService.getAll();
    }

    // GET /api/users/1
    @GetMapping("/{id}")
    public UserResponse getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    // POST /api/users
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse create(@Valid @RequestBody UserRequest request) {
        return userService.create(request);
    }

    // PUT /api/users/1
    @PutMapping("/{id}")
    public UserResponse update(@PathVariable Long id, @Valid @RequestBody UserRequest request) {
        return userService.update(id, request);
    }

    // DELETE /api/users/1
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
