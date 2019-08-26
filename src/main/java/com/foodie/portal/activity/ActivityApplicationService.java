package com.foodie.portal.activity;

import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ActivityApplicationService {

    @Autowired
    private ActivityRepository activityRepository;

    public void addActivity(CreateActivityCommand activityCommand) {
        var activity = Activity.create(activityCommand.getTitle(),activityCommand.getSubTitle(),
                activityCommand.getDesc(),activityCommand.getCategory(),activityCommand.getDuration(),
                activityCommand.getLimit(),activityCommand.getImages(),activityCommand.getLanguage(),
                activityCommand.getAddress(),activityCommand.getCityId(),activityCommand.getCityName(),activityCommand.getCostList(),
                activityCommand.getDates(),activityCommand.getState());
        activityRepository.save(activity);
    }

    public Collection<Activity> find() {
        return activityRepository.find();
    }
}
