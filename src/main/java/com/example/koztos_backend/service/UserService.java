package com.example.koztos_backend.service;

import com.example.koztos_backend.dto.AdminDTO;
import com.example.koztos_backend.dto.UserCreateDTO;
import com.example.koztos_backend.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO registerAdmin(AdminDTO admin);
    UserDTO registerUser(UserCreateDTO dto);

    UserDTO updateUser(long id, UserCreateDTO dto);
    void deleteUser(long id);
    List<UserDTO> getUsersByRole(String roleName);
    UserDTO getUserById(long id);
}
