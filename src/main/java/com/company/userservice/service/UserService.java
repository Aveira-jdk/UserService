package com.company.userservice.service;

import com.company.userservice.model.dto.request.SignUpRequestDto;
import com.company.userservice.model.dto.request.UserRequestDto;
import com.company.userservice.model.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface UserService {

    void add(SignUpRequestDto signUpRequestDto);

    User update(Long id, UserRequestDto userRequestDto);

    void delete(String username);

    User getById(Long id);

    User findUserByUsername(String username);

    List<User> getAllUsers(int page, int size);

    List<User> getUsersById(Set<Long> userIds);

    User getUserById(Long userId);

}
