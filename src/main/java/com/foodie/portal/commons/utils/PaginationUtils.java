package com.foodie.portal.commons.utils;

import com.foodie.portal.article.repository.ArticleEntity;
import com.foodie.portal.commons.Pagination;
import org.springframework.data.domain.Page;

import java.util.function.Function;
import java.util.stream.Collectors;

public class PaginationUtils {

    public static <S, T> Pagination<S> map(Pagination<T> pagination, Function<T, S> mapper) {
        return Pagination.of(pagination.getTotal(),
                pagination.getCurrent(),
                pagination.getPageSize(),
                pagination.getContent().stream().map(mapper).collect(Collectors.toList()));
    }

    public static <S, T> Pagination<S> map(Page<T> page, Function<T,S> mapper) {
        return Pagination.of((int)page.getTotalElements(),
                page.getNumber() + 1,
                page.getSize(),
                page.getContent().stream().map(mapper).collect(Collectors.toList()));
    }
}
