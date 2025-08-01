package com.rupeeroute.Auth.Service;

import com.rupeeroute.Auth.DTO.AuthRequest;
import com.rupeeroute.Auth.Model.User;
import com.rupeeroute.Auth.Repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService
{
    @Autowired
    AuthRepository authRepository;
    public ResponseEntity<User> registerUser(User user)
    {

        //code to generate 5 characters alphanumeric string
        String randomString = java.util.UUID.randomUUID().toString().replaceAll("[^A-Za-z0-9]", "").substring(0, 5);
        user.setUsername(randomString);


        // Set default values for role and status
        user.setRole("USER");
        user.setStatus("ACTIVE");

        //Bcrypt password hashing
        BCryptPasswordEncoder encoder =new BCryptPasswordEncoder(12);
        user.setPassword(encoder.encode(user.getPassword()));

        authRepository.save(user);
        return ResponseEntity.ok(user);
    }

    public ResponseEntity validateUser(AuthRequest authRequest)
    {
        return null;
    }


}
