package com.example.RegisterLogin.Repository;


import com.example.RegisterLogin.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@EnableJpaRepositories
@Repository
public interface UserRepo extends JpaRepository<User,Integer>
{
    Optional<User> findOneByUsernameAndPassword(String username, String password);

    User findByUsername(String username);
}
