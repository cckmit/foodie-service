package com.foodie.portal.merchant;

import com.foodie.portal.commons.Pagination;
import com.github.jsonzou.jmockdata.JMockData;
import com.github.jsonzou.jmockdata.TypeReference;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MerchantApplicationService {

    private Map<String, Merchant> merchants = JMockData.mock(new TypeReference<Map<String, Merchant>>() {
    });
    @Autowired
    private MerchantRepository merchantRepository;

    public Pagination<Merchant> merchants(int page, int size) {
        return merchantRepository.findByPage(page - 1, size);
    }

    public void addMerchant(Merchant merchantCommand) {
        var merchant = Merchant.create(merchantCommand.getName(), merchantCommand.getEmail(), merchantCommand.getCity(),
                merchantCommand.getDescription(), merchantCommand.getActiveDesc(), merchantCommand.getImages());
        merchants.put(merchant.getId(), merchant);
        merchantRepository.save(merchant);
    }

    public Merchant detail(String id) {
        return merchants.get(id);
    }

    public Merchant updateMerchant(String id, Merchant merchantCommand) {
        return merchants.put(id, merchantCommand);
    }

    public void deleteMerchant(String id) {
        merchants.remove(id);
    }
}
