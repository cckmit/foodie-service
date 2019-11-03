package com.foodie.portal.wallet;

import com.foodie.portal.commons.PageCommand;
import com.foodie.portal.commons.Pagination;
import com.foodie.portal.wallet.command.WithdrawCommand;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "（管理端）商家钱包")
@RestController
@RequestMapping("admin/wallet/merchant")
public class AdminWalletController {

    @Autowired
    private WalletApplicationService walletApplicationService;

    @GetMapping()
    public Pagination<MerchantWallet> list(PageCommand command) {
        return walletApplicationService.list(command.getPage(), command.getSize());
    }

    @PostMapping("{merchantId}/withdrawal")
    public void withdrawal(@PathVariable String merchantId, @RequestBody WithdrawCommand command) {
        walletApplicationService.withdraw(merchantId, command.getAmount());
    }
}
