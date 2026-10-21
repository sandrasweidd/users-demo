package com.example.usersdemo.service;

import com.example.usersdemo.dto.UserRequest;
import com.example.usersdemo.dto.UserResponse;
import com.example.usersdemo.entity.User;
import com.example.usersdemo.exception.EmailAlreadyUsedException;
import com.example.usersdemo.exception.UserNotFoundException;
import com.example.usersdemo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// IMPLEMENTS: hon "kif" bta3mol kel shi talabo el interface.
// @Service: Spring bi3mol object wa7ad (Bean) men hal class w bya3ti la yalli bedo yeh.
@Service
public class UserServiceImpl implements UserService {

    // ENCAPSULATION: private final, ma had men barra byegh'ayyro
    private final UserRepository userRepository;

    // DEPENDENCY INJECTION: ma 3am na3mol "new UserRepository()".
    // Spring byeb3atlna yeh hon automatic.
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserResponse> getAll() {
        return userRepository.findAll()
                .stream()
                .map(UserResponse::from)
                .toList();
    }

    @Override
    public UserResponse getById(Long id) {
        return UserResponse.from(findUserOrThrow(id));
    }

    @Override
    public UserResponse create(UserRequest request) {
        if (userRepository.existsByEmail(request.email())) {
            throw new EmailAlreadyUsedException(request.email());
        }
        // Bi mashrou3 7a2i2i lazem ta3mol hash lal password (BCrypt) abel ma tsajjlo
        User user = new User(request.name(), request.email(), request.password());
        return UserResponse.from(userRepository.save(user));
    }

    @Override
    public UserResponse update(Long id, UserRequest request) {
        User user = findUserOrThrow(id);
        // Eza ghayyar el email la wa7ad mesta3mal 3and user tene => error
        if (!user.getEmail().equals(request.email())
                && userRepository.existsByEmail(request.email())) {
            throw new EmailAlreadyUsedException(request.email());
        }
        user.setName(request.name());
        user.setEmail(request.email());
        return UserResponse.from(userRepository.save(user));
    }

    @Override
    public void delete(Long id) {
        User user = findUserOrThrow(id);
        userRepository.delete(user);
    }

    // private: method mesa3de, bas hal class byesta3mela
    private User findUserOrThrow(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
}
