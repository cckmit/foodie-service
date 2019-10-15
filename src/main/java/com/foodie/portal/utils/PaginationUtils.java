package com.foodie.portal.utils;

import com.foodie.portal.commons.Pagination;

import java.util.function.Function;
import java.util.stream.Collectors;

public class PaginationUtils {

    public static <S, T> Pagination<S> map(Pagination<T> pagination, Function<T, S> mapper) {
        return Pagination.of(pagination.getTotal(),
                pagination.getCurrent(),
                pagination.getPageSize(),
                pagination.getContent().stream().map(mapper).collect(Collectors.toList()));
    }
}
