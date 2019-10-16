package com.foodie.portal.activity.representation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityRepresentationService {

    @Autowired
    private ActivityRepresentationRepository activityRepository;

    public List<ActivityRepresentation> topRatedActivities() {
        return activityRepository.findTopActivity();
    }
}
