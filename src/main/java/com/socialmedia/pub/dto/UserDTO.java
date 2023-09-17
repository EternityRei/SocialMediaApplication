package com.socialmedia.pub.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@JsonTypeName("USER")
public class UserDTO {
    private String id;
    private String username;
    private String fullName;
    private String email;
    private boolean active;
    private Date registrationDate;
}

