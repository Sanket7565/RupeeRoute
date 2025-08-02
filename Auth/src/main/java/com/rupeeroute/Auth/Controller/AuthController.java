package com.rupeeroute.Auth.Controller;

import com.rupeeroute.Auth.DTO.AuthRequest;
import com.rupeeroute.Auth.Model.User;
import com.rupeeroute.Auth.Security.CustomUserDetailsService;
import com.rupeeroute.Auth.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController
{
    @Autowired
    AuthService authService;

   //http://localhost:8081/api/v1/auth/register
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody User user) {
        return authService.registerUser(user);
    }


    // http://localhost:8081/api/v1/auth/login
   /* @GetMapping("/login")

    public ResponseEntity ValidateLogin(@RequestBody AuthRequest authRequest) {
        return authService.validateUser(authRequest);
    }*/

}



