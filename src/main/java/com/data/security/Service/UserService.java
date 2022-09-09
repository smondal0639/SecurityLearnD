package com.data.security.Service;

import com.data.security.Entity.Users;
import com.data.security.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Users createUser(Users user){
        String passwd = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwd);
        return userRepository.save(user);
    }
}
