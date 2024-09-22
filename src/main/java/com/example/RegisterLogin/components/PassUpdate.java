package com.example.RegisterLogin.components; // Sửa đường dẫn cho đúng với cấu trúc package của bạn

import com.example.RegisterLogin.service.Impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PassUpdate implements CommandLineRunner {
    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        userService.updatePasswords();
    }
}
