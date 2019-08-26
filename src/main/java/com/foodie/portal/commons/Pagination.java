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


}
