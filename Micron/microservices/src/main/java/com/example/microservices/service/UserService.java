package com.example.microservices.service;

import com.example.microservices.entiity.User;
import com.example.microservices.exceptionhandling.EmailAlreadyExistsException;
import com.example.microservices.exceptionhandling.ResourceNotFoundException;
import com.example.microservices.jwtconfigure.JwtUtil;
import com.example.microservices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public User saveUser(User user) {
        Optional<User> existingUser = Optional.ofNullable(userRepository.findByEmail(user.getEmail()));
        if (existingUser.isPresent()) {
            throw new EmailAlreadyExistsException("Email already exists: " + user.getEmail());
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public String loginUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return jwtUtil.generateToken(user.getEmail());
        }
        return null;
    }

    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> new User(user.getId(), user.getName(), user.getEmail()))
                .collect(Collectors.toList());
    }

    public void deleteUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.delete(user.get());
        } else {
            throw new ResourceNotFoundException("User already deleted with id: " + id);
        }
    }

    public Optional<Optional<User>> findById(Long id) {
        return Optional.ofNullable(userRepository.findById(id));
    }

}
