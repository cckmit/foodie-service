package com.foodie.portal.publicbenefit.repository;

import com.foodie.portal.commons.BaseMapper;
import com.foodie.portal.commons.utils.JsonUtils;
import com.foodie.portal.order.model.OrderInfo;
import com.foodie.portal.publicbenefit.PublicBenefit;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PublicBenefitMapper extends BaseMapper<PublicBenefit, PublicBenefitEntity> {
    PublicBenefitMapper INSTANCE = Mappers.getMapper(PublicBenefitMapper.class);



    default OrderInfo map(String orderInfo) {
        return JsonUtils.toBean(orderInfo, OrderInfo.class);
    }

    default String map(OrderInfo orderInfo) {
        return JsonUtils.toJsonStr(orderInfo);
    }
}
