package com.foodie.portal.feedback;

import com.foodie.portal.commons.Pagination;
import com.foodie.portal.feedback.model.UserFeedback;
import com.foodie.portal.feedback.repository.UserFeedbackEntityMapper;
import com.foodie.portal.feedback.repository.UserFeedbackJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
public class UserFeedbackRepository {

    @Autowired
    private UserFeedbackJpaRepository userFeedbackJpaRepository;

    public void save(UserFeedback feedback) {
        userFeedbackJpaRepository.save(UserFeedbackEntityMapper.INSTANCE.from(feedback));
    }

    public Pagination<UserFeedback> findAll(int page, int size) {
        return UserFeedbackEntityMapper.INSTANCE.to(userFeedbackJpaRepository.findAll(PageRequest.of(page, size)));
    }

    public UserFeedback byId(String id) {
        return userFeedbackJpaRepository.findById(id)
                .map(UserFeedbackEntityMapper.INSTANCE::to)
                .orElse(null);
    }
}
