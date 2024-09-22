package com.example.RegisterLogin.service.Impl;
import com.example.RegisterLogin.Dto.UserDTO;
import com.example.RegisterLogin.Dto.LoginDTO;
import com.example.RegisterLogin.response.LoginMessage;

public interface UserService {
    String addUser(UserDTO userDTO);
    LoginMessage loginUser(LoginDTO loginDTO);
    void updatePasswords();
}
