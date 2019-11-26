package com.foodie.portal.feedback;

import com.foodie.portal.feedback.command.CreateMerchantFeedbackCommand;
import com.foodie.portal.feedback.command.CreateUserFeedbackCommand;
import com.foodie.portal.user.model.User;
import io.swagger.annotations.Api;
import lombok.var;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "（用户）反馈")
@RestController
@RequestMapping("feedback")
public class UserFeedbackController {

    @Autowired
    private UserFeedbackApplicationService userFeedbackApplicationService;

    @PostMapping
    public void create(@RequestBody CreateUserFeedbackCommand command) {
        var user = (User) SecurityUtils.getSubject().getPrincipal();
        userFeedbackApplicationService.create(command, user);
    }
}
