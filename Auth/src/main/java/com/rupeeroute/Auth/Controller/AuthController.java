package com.rupeeroute.Auth.Controller;

import com.rupeeroute.Auth.DTO.AuthRequest;
import com.rupeeroute.Auth.Model.User;
import com.rupeeroute.Auth.Security.JwtService;
import com.rupeeroute.Auth.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController
{

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtService jwtService;

    @Autowired
    AuthService authService;

   //http://localhost:8081/api/v1/auth/register
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody User user) {
        return authService.registerUser(user);
    }


    //http://localhost:8081/api/v1/auth/login
   @GetMapping("/login")

    public String ValidateLogin(@RequestBody AuthRequest authRequest)
   {
        // Authenticate the user using the authentication manager
       Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if(authentication.isAuthenticated())
        {
            return jwtService.generateToken(authRequest.getUsername());

        }
        else {
            return "Login failed";
        }

    }

}



