package com.socialmedia.pub.service;

import com.socialmedia.pub.dto.UserDTO;
import com.socialmedia.pub.entity.User;
import com.socialmedia.pub.mapper.UserMapper;
import com.socialmedia.pub.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        User user = userMapper.userDTOToUser(userDTO);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        return userMapper.userToUserDTO(userRepository.save(user));
    }
}
