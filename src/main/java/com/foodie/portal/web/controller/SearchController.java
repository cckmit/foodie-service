package com.foodie.portal.web.controller;

import com.foodie.portal.web.model.SearchRepresentation;
import com.foodie.portal.web.service.SearchRepresentationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class SearchController {

    private SearchRepresentationService searchRepresentationService;

    @GetMapping("search")
    public SearchRepresentation search(String keyword) {
        return searchRepresentationService.search(keyword);
    }
}
