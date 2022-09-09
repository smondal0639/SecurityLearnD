package com.data.security.Service;

import com.data.security.Entity.CustomUserDetails;
import com.data.security.Entity.Users;
import com.data.security.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = userRepository.findByusername(username).orElseThrow(()->new UsernameNotFoundException("Could not find user"));
        return  new CustomUserDetails(user);
    }
}
