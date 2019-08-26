package com.foodie.portal.commons;

import org.springframework.data.domain.Page;

import java.util.List;

public interface BaseMapper<DM, T> {

    DM to(T to);

    T from(DM from);

    List<DM> to(List<T> to);

    List<DM> from(List<DM> from);

    default Pagination<DM> to(Page<T> page) {
        return Pagination.<DM>builder()
                .totalPages(page.getTotalPages())
                .total((int)page.getTotalElements())
                .current(page.getNumber())
                .pageSize(page.getSize())
                .content(to(page.getContent()))
                .build();
    }
}
