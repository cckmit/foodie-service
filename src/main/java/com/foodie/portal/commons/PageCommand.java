package com.foodie.portal.commons;

import lombok.Data;

@Data
public class PageCommand {
    private int page = 1;
    private int size = 10;
}
