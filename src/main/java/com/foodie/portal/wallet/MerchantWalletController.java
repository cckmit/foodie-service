package com.foodie.portal.wallet;

import com.foodie.portal.commons.PageCommand;
import com.foodie.portal.commons.Pagination;
import com.foodie.portal.user.model.Merchant;
import com.foodie.portal.wallet.command.UpdateWithdrawInfoCommand;
import com.foodie.portal.wallet.representation.IncomeItemRepresentation;
import com.foodie.portal.wallet.representation.WalletRepresentationService;
import com.foodie.portal.wallet.representation.WithdrawalRepresentation;
import io.swagger.annotations.Api;
import lombok.var;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "（商家）钱包")
@RestController
@RequestMapping("merchant/wallet")
public class MerchantWalletController {

    @Autowired
    private WalletRepresentationService walletRepresentationService;
    @Autowired
    private WalletApplicationService walletApplicationService;

    @GetMapping("income")
    public Pagination<IncomeItemRepresentation> listIncome(PageCommand command) {
        var merchant = (Merchant) SecurityUtils.getSubject().getPrincipal();
        return walletRepresentationService.listServiceIncome(merchant.getId(), command.getPage(), command.getSize());
    }

    @GetMapping("withdrawal")
    public Pagination<WithdrawalRepresentation> listWithdrawal(PageCommand command) {
        var merchant = (Merchant) SecurityUtils.getSubject().getPrincipal();
        return walletRepresentationService.listWithdrawal(merchant.getId(), command.getPage(), command.getSize());
    }

    @PostMapping("withdraw-info")
    public void updateWithdrawInfo(@RequestBody UpdateWithdrawInfoCommand command) {
        var merchant = (Merchant) SecurityUtils.getSubject().getPrincipal();
        walletApplicationService.updateWithdrawInfo(merchant.getId(), command);
    }
}
