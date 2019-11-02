package com.foodie.portal.user;

import com.foodie.portal.commons.ErrorCode;
import com.foodie.portal.commons.Pagination;
import com.foodie.portal.commons.RestException;
import com.foodie.portal.user.command.UpdateUserInfoCommand;
import com.foodie.portal.user.command.UserChangePasswordCommand;
import com.foodie.portal.user.command.UserRegisterCommand;
import com.foodie.portal.user.model.Merchant;
import com.foodie.portal.user.model.SysUser;
import com.foodie.portal.user.model.User;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserApplicationService {

    @Autowired
    private UserRepository userRepository;

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User register(UserRegisterCommand command) {
        if (Objects.nonNull(userRepository.findByEmail(command.getEmail())) ) {
            throw new RestException(ErrorCode.FAILED, "用户已存在");
        }
        var user = User.create(command.getEmail(), command.getPassword());
        userRepository.save(user);
        return user;
    }

    public List<String> selectPermissionByUserName(String username) {
        return null;
    }

    public void updateInfo(String id, UpdateUserInfoCommand command) {
        User user = userRepository.findById(id);
        user.updateInfo(command.getAvatar(), command.getLastName(),
                command.getFirstName(), command.getNationality(),
                command.getIdType(), command.getIdNumber());
        userRepository.save(user);

    }

    public void changePassword(String id, UserChangePasswordCommand command) {
        User user = userRepository.findById(id);
        user.changePassword(command.getOldPassword(), command.getNewPassword());
        userRepository.save(user);
    }

    public User userInfo(String id) {
        return userRepository.findById(id);
    }

    public Pagination<User> list(int page, int size) {
        return userRepository.findAll(page - 1, size);
    }

    public void collectActivity(String activityId, User user) {
    }
}
