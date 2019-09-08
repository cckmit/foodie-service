//package com.foodie.portal.activity.representation;
//
//import com.foodie.portal.activity.ActivityRepository;
//import com.foodie.portal.activity.model.Activity;
//import com.foodie.portal.commons.Pagination;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.stream.Collectors;
//
//@Service
//public class ActivityRepresentationService {
//
//    @Autowired
//    private ActivityRepository activityRepository;
//
//    ActivityRepresentationMapper activityRepresentationMapper = ActivityRepresentationMapper.INSTANCE;
//
//    public Pagination<Activity> find(int page, int size) {
//        Pagination activityPagination = activityRepository.find(page - 1, size);
//
//
//        activityPagination.setContent(activityPagination.getContent().stream().map(activityRepresentationMapper::from).collect(Collectors.toList()));
//    }
//}
