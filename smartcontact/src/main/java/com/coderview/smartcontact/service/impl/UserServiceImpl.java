package com.coderview.smartcontact.service.impl;

import com.coderview.smartcontact.model.User;
import com.coderview.smartcontact.repository.UserRepo;
import com.coderview.smartcontact.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    UserRepo userRepo;

    @Override
    public User registerUser(User user) {
        user.setRole("ROLE_USER");
        user.setEnabled(true);
        user.setImageUrl("default.png");

        // Encrypt password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User saveUser = userRepo.save(user);

        return saveUser;
    }
}
