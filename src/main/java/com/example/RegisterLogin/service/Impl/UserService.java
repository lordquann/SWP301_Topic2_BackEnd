package com.example.RegisterLogin.service.Impl;
import com.example.RegisterLogin.Dto.UserDTO;
import com.example.RegisterLogin.Dto.LoginDTO;
import com.example.RegisterLogin.response.LoginMessage;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

public interface UserService {
    String addUser(@Valid UserDTO userDTO, BindingResult bindingResult);
    LoginMessage loginUser(LoginDTO loginDTO);
    void updatePasswords();
}
