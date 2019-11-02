package com.foodie.portal.feedback;

import com.foodie.portal.commons.PageCommand;
import com.foodie.portal.commons.Pagination;
import com.foodie.portal.feedback.dto.MerchantFeedbackDto;
import com.foodie.portal.feedback.dto.MerchantFeedbackDtoMapper;
import com.foodie.portal.feedback.dto.UserFeedbackDto;
import com.foodie.portal.feedback.dto.UserFeedbackDtoMapper;
import com.foodie.portal.feedback.model.MerchantFeedback;
import com.foodie.portal.feedback.model.UserFeedback;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "（管理端）反馈管理")
@RestController
@RequestMapping("admin/feedback")
public class AdminFeedbackController {

    @Autowired
    private MerchantFeedbackApplicationService merchantFeedbackApplicationService;
    @Autowired
    private UserFeedbackApplicationService userFeedbackApplicationService;

    @GetMapping("merchant-feedback")
    public Pagination<MerchantFeedbackDto> listMerchantFeedback(PageCommand command) {
        return MerchantFeedbackDtoMapper.INSTANCE.from(merchantFeedbackApplicationService.list(command.getPage(), command.getSize()));
    }

    @GetMapping("merchant-feedback/{id}")
    public MerchantFeedbackDto detailMerchantFeedback(@PathVariable String id) {
        return MerchantFeedbackDtoMapper.INSTANCE.from(merchantFeedbackApplicationService.detail(id));
    }

    @GetMapping("user-feedback")
    public Pagination<UserFeedbackDto> listUserFeedback(PageCommand command) {
        return UserFeedbackDtoMapper.INSTANCE.from(userFeedbackApplicationService.list(command.getPage(), command.getSize()));
    }

    @GetMapping("user-feedback/{id}")
    public UserFeedbackDto detailUserFeedback(@PathVariable String id) {
        return UserFeedbackDtoMapper.INSTANCE.from(userFeedbackApplicationService.detail(id));
    }
}
