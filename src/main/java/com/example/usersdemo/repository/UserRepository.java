package com.example.usersdemo.repository;

import com.example.usersdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

// INTERFACE + INHERITANCE:
// Ma katabna wala method, bas btewras save(), findById(), findAll(), deleteById()...
// Spring bi3mol el implementation 3annak w2t el run.
public interface UserRepository extends JpaRepository<User, Long> {

    // Spring bifham men esm el method shu lazem ya3mol: SELECT ... WHERE email = ?
    boolean existsByEmail(String email);
}
