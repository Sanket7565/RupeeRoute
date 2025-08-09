package com.rupeeroute.Auth.Security;

import com.rupeeroute.Auth.Model.User;
import com.rupeeroute.Auth.Repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private AuthRepository authRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //
        {
            User user = authRepository.findByUsername(username);

            if(user == null)
            {
                throw new UsernameNotFoundException("User not found with username: " + username);
            }
            return new CustomUserDetails(user);
        }
    }
}
