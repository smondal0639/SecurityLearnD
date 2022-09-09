package com.data.security.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private String userId;
    private String firstName;
    private String lastName;
    private String emailId;
    private String roles;

}
