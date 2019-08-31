package com.foodie.portal.merchant;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Api(tags = "商家管理")
@RestController
@RequestMapping("merchants")
public class MerchantController {

    @Autowired
    private MerchantApplicationService merchantApplicationService;

    @ApiOperation("商家列表")
    @GetMapping
    public Collection<Merchant> merchants() {
        return merchantApplicationService.merchants();
    }

    @ApiOperation("添加商家")
    @PostMapping
    public void addMerchant(@RequestBody Merchant merchantCommand) {
        merchantApplicationService.addMerchant(merchantCommand);
    }

    @ApiOperation("商家详情")
    @GetMapping("{id}")
    public Merchant detail(@PathVariable String id) {
        return merchantApplicationService.detail(id);
    }

    @ApiOperation("修改商家信息")
    @PatchMapping("{id}")
    public Merchant updateMerchant(@PathVariable String id, @RequestBody Merchant merchantCommand) {
        return merchantApplicationService.updateMerchant(id, merchantCommand);
    }

    @ApiOperation("删除商家")
    @DeleteMapping("{id}")
    public void deleteMerchant(@PathVariable String id) {
        merchantApplicationService.deleteMerchant(id);
    }


}
