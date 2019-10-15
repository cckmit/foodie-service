package com.foodie.portal.user;

import com.foodie.portal.commons.Pagination;
import com.foodie.portal.user.model.User;
import com.foodie.portal.user.repository.UserEntityMapper;
import com.foodie.portal.user.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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

    public User findById(String id) {
        return UserEntityMapper.instance.to(userJpaRepository.findById(id).orElse(null));
    }

    public Pagination<User> findAll(int page, int size) {
        return UserEntityMapper.instance.to(userJpaRepository.findAll(PageRequest.of(page,size)));
    }
}
