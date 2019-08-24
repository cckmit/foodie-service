package com.foodie.portal.merchant;

import com.foodie.portal.city.City;
import com.github.jsonzou.jmockdata.JMockData;
import com.github.jsonzou.jmockdata.TypeReference;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@Api(tags = "商家管理")
@RestController
@RequestMapping("merchants")
public class MerchantController {

    private Map<String, Merchant> merchants = JMockData.mock(new TypeReference<Map<String, Merchant>>() {
    });

    @ApiOperation("商家列表")
    @GetMapping
    public Collection<Merchant> merchants() {
        return merchants.values();
    }

    @ApiOperation("添加商家")
    @PostMapping
    public void addMerchant(@RequestBody Merchant merchantCommand) {
        var merchant = new Merchant();
        merchants.put(merchant.getId(), merchant);
    }


}
