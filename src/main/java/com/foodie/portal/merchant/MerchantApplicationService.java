package com.foodie.portal.merchant;

import com.foodie.portal.city.City;
import com.github.jsonzou.jmockdata.JMockData;
import com.github.jsonzou.jmockdata.TypeReference;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;
import java.util.Map;

@Service
public class MerchantApplicationService {

    private Map<String, Merchant> merchants = JMockData.mock(new TypeReference<Map<String, Merchant>>() {
    });

    public Collection<Merchant> merchants() {
        return merchants.values();
    }

    public void addMerchant(@RequestBody Merchant merchantCommand) {
        var merchant = Merchant.create(merchantCommand.getName(), merchantCommand.getEmail(), merchantCommand.getCity(),
                merchantCommand.getDesc(), merchantCommand.getActiveDesc(), merchantCommand.getImages());
        merchants.put(merchant.getId(), merchant);
    }

    public Merchant detail(@PathVariable String id) {
        return merchants.get(id);
    }

    public Merchant updateMerchant(@PathVariable String id, @RequestBody Merchant merchantCommand) {
        return merchants.put(id, merchantCommand);
    }

    public void deleteMerchant(@PathVariable String id) {
        merchants.remove(id);
    }
}
