package com.socialmedia.pub.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.validation.constraints.Pattern;
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

    @Pattern(regexp = "(^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{7,30}$)?",
            message = "Your password must contain upper and lower case letters and numbers, at least 7 and maximum 30 characters." +
                    "Password cannot contains spaces")
    private String password;

    @Pattern(regexp = "(^[^@]+@[^@.]+\\.[^@.]+$)?", message = "Email address should contain @ and . symbols")
    private String email;
    private boolean active;
    private Date registrationDate;
}

