package com.foodie.portal.wallet;

import com.foodie.portal.user.model.Merchant;
import com.foodie.portal.wallet.representation.IncomeItemRepresentation;
import com.foodie.portal.wallet.representation.WalletRepresentationService;
import com.foodie.portal.wallet.representation.WithdrawalRepresentation;
import io.swagger.annotations.Api;
import lombok.var;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "（商家）钱包")
@RestController
@RequestMapping("merchant/wallet")
public class MerchantWalletController {

    @Autowired
    private WalletRepresentationService walletRepresentationService;

    @GetMapping("income")
    public List<IncomeItemRepresentation> listIncome() {
        var merchant = (Merchant) SecurityUtils.getSubject().getPrincipal();
        return walletRepresentationService.listServiceIncome(merchant.getId());
    }

    @GetMapping("withdrawal")
    public List<WithdrawalRepresentation> listWithdrawal() {
        var merchant = (Merchant) SecurityUtils.getSubject().getPrincipal();
        return walletRepresentationService.listWithdrawal(merchant.getId());
    }
}
