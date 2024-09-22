package com.example.RegisterLogin.Controller;
import com.example.RegisterLogin.Dto.UserDTO;
import com.example.RegisterLogin.Dto.LoginDTO;
import com.example.RegisterLogin.response.LoginMessage;
import com.example.RegisterLogin.service.Impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO) {
        LoginMessage loginMessage = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginMessage);
    }

    @PostMapping("/add")
    public String addUser(@RequestBody UserDTO userDTO)
    {
        String id = userService.addUser(userDTO);
        return id;
    }

}

