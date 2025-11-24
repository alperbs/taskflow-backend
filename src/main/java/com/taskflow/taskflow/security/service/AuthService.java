package com.taskflow.taskflow.security.service;

import com.taskflow.taskflow.model.User;
import com.taskflow.taskflow.repository.UserRepository;
import com.taskflow.taskflow.security.LoginRequest;
import com.taskflow.taskflow.security.RegisterRequest;
import com.taskflow.taskflow.security.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public String register(RegisterRequest request) {

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);

        // ❗ Token user üzerinden değil → username üzerinden üretilecek
        return jwtService.generateToken(user.getUsername());
    }

    public String login(LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow();

        // ❗ Aynı şekilde login’de de username üzerinden token üretilecek
        return jwtService.generateToken(user.getUsername());
    }
}
