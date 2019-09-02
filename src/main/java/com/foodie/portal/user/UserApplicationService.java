package com.foodie.portal.user;

import com.foodie.portal.user.command.UserRegisterCommand;
import com.foodie.portal.user.model.SysUser;
import com.foodie.portal.user.model.User;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserApplicationService {

    @Autowired
    private UserRepository userRepository;

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User register(UserRegisterCommand command) {
        var user = User.create(command.getEmail(), command.getPassword());
        userRepository.save(user);
        return user;
    }

    public List<String> selectPermissionByUserName(String username) {
        return null;
    }
}
