package com.foodie.portal.merchant;

import com.foodie.portal.city.City;
import com.github.jsonzou.jmockdata.JMockData;
import com.github.jsonzou.jmockdata.TypeReference;
import lombok.var;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("merchant")
public class MerchantController {

    private Map<String, Merchant> merchants = JMockData.mock(new TypeReference<Map<String, Merchant>>() {
    });

    @GetMapping
    public Collection<Merchant> cities() {
        return merchants.values();
    }

    @PostMapping
    public void addCity(@RequestBody Merchant merchantCommand) {
        var merchant = new Merchant();
        merchants.put(merchant.getId(), merchant);
    }


}
