package com.foodie.portal.user;

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
    private String email;
    private String city;
    private String description;
    private String activeDesc;
    private String images;
    private MerchantStatus status;

    public static MerchantDto toDto(Merchant merchant) {
        return MerchantDto.builder()
                .name(merchant.getName())
                .activeDesc(merchant.getActiveDesc())
                .city(merchant.getCity())
                .description(merchant.getDescription())
                .images(merchant.getImages())
                .email(merchant.getEmail())
                .status(merchant.getStatus())
                .activeDesc(merchant.getActiveDesc())
                .build();
    }
}
