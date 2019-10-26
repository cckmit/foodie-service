package com.foodie.portal.user.command;

import com.foodie.portal.user.model.Merchant;
import com.foodie.portal.user.model.MerchantStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MerchantDto {
    private String name;


    public static MerchantDto toDto(Merchant principal) {
        return MerchantDto.builder()
                .name(principal.getName())
                .build();
    }
}
