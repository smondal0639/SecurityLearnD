package com.data.security.Controller;

import com.data.security.Dto.UserDto;
import com.data.security.Entity.Users;
import com.data.security.Service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addnew")
    public ResponseEntity<?> createNewUser(@RequestBody Users user){

        try {
            Users createdUser = userService.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("User Created with username - "+createdUser.getUsername());
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }
    @GetMapping("/getalluser")
    public ResponseEntity<?> getUserDetails(){
        try {
            return ResponseEntity.ok(userService.getAllUser());
        }
        catch (Exception exp){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(exp.getMessage());
        }

    }
}
