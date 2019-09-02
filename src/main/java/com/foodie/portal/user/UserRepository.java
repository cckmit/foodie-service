package com.foodie.portal.user;

import com.foodie.portal.user.model.User;
import com.foodie.portal.user.repository.UserEntityMapper;
import com.foodie.portal.user.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRepository {

    @Autowired
    private UserJpaRepository userJpaRepository;

    public void save(User user) {
        userJpaRepository.save(UserEntityMapper.instance.from(user));
    }

    public User findByEmail(String email) {
        return UserEntityMapper.instance.to(userJpaRepository.findByEmail(email));
    }
}
