package com.example.RegisterLogin.service.Impl;
import com.example.RegisterLogin.Dto.UserDTO;
import com.example.RegisterLogin.Dto.LoginDTO;
import com.example.RegisterLogin.Entity.User;
import com.example.RegisterLogin.Repository.UserRepo;
import com.example.RegisterLogin.response.LoginMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public String addUser(UserDTO userDTO) {
        User user = new User(
                userDTO.getId(),
                userDTO.getUsername(),
                userDTO.getRole(),
                this.passwordEncoder.encode(userDTO.getPassword())
        );
        userRepo.save(user);
        return user.getUsername();
    }
    @Override
    public LoginMessage loginUser(LoginDTO loginDTO) {
        String msg = "";
        User user1 = userRepo.findByUsername(loginDTO.getUsername());
        if (user1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user = userRepo.findOneByUsernameAndPassword(loginDTO.getUsername(), encodedPassword);
                if (user.isPresent()) {
                    return new LoginMessage("Login Success", true);
                } else {
                    return new LoginMessage("Login Failed", false);
                }
            } else {
                return new LoginMessage("Wrong Password", false);
            }
        }else {
            return new LoginMessage("Email/Phone not exits", false);
        }
    }

    @Override
    public void updatePasswords() {
        // Lấy tất cả người dùng và mã hóa mật khẩu nếu chưa mã hóa
        List<User> users = userRepo.findAll();
        for (User user : users) {
            // Nếu mật khẩu không được mã hóa (mật khẩu hiện tại là plain text)
            if (!user.getPassword().startsWith("$2a$")) { // Kiểm tra xem mật khẩu đã được mã hóa với BCrypt chưa
                user.setPassword(passwordEncoder.encode(user.getPassword())); // Mã hóa mật khẩu
                userRepo.save(user); // Cập nhật người dùng với mật khẩu mới
            }
        }
    }
}
