package com.foodie.portal.feedback.model;

import cn.hutool.core.util.IdUtil;
import com.foodie.portal.user.model.Merchant;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MerchantFeedback extends Feedback {
    private Merchant merchant;

    public MerchantFeedback(String title, String content, Merchant merchant) {
        this.id = IdUtil.fastSimpleUUID();
        this.title = title;
        this.content = content;
        this.merchant = merchant;
    }

    public static MerchantFeedback create(String title, String content, Merchant merchant) {
        return new MerchantFeedback(title, content, merchant);
    }
}
