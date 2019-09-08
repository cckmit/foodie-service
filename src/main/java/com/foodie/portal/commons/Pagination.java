package com.foodie.portal.commons;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 01182799
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pagination<T> {
    private Integer totalPages;
    private Integer total;
    private Integer current;
    private Integer pageSize;

    /**
     * 业务对象
     */
    private List<T> content;

    public Pagination(Integer total, Integer current, Integer pageSize, List<T> content) {
        this.totalPages = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
        this.total = total;
        this.current = current;
        this.pageSize = pageSize;
        this.content = content;
    }

    public static <T> Pagination<T> of(int total, int current, int pageSize, List<T> content) {
        return new Pagination<>(total, current, pageSize, content);
    }

}
