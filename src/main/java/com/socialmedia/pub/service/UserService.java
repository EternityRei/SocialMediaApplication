package com.socialmedia.pub.service;

import com.socialmedia.pub.dto.UserDTO;
import com.socialmedia.pub.entity.User;

public interface UserService {
    UserDTO registerUser (UserDTO userDTO);
}
