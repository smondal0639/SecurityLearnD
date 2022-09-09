package com.data.security.Service;

import com.data.security.Dto.UserDto;
import com.data.security.Entity.Users;
import com.data.security.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /*@Autowired
    private SCryptPasswordEncoder spassEncoder;
*/
    public Users createUser(Users user){
        String passwd = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwd);
        return userRepository.save(user);
    }

    public List<UserDto> getAllUser(){
        List<Users> foundUsers = userRepository.findAll();
        List<UserDto> usersDto = foundUsers.stream().map(
                (user)-> {return new UserDto(user.getUsername(), user.getFirstName(), user.getLastName(),
                        user.getEmailId(), user.getRoles());}
                ).collect(Collectors.toList());

        return usersDto;
    }
}
