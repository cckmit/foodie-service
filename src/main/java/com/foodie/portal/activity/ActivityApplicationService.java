package com.foodie.portal.activity;

import com.foodie.portal.commons.Pagination;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Pagination<Activity> find(int page, int size) {
        return activityRepository.find(page - 1, size);
    }

    public Activity retrieveById(String id) {
        return activityRepository.findById(id);
    }

    public void updateActivity(String id, CreateActivityCommand activityCommand) {
        Activity activity = activityRepository.findById(id);
        activity.update(activityCommand.getTitle(),activityCommand.getSubTitle(),
                activityCommand.getDesc(),activityCommand.getCategory(),activityCommand.getDuration(),
                activityCommand.getLimit(),activityCommand.getImages(),activityCommand.getLanguage(),
                activityCommand.getAddress(),activityCommand.getCityId(),activityCommand.getCityName(),activityCommand.getCostList(),
                activityCommand.getDates(),activityCommand.getState());
        activityRepository.save(activity);
    }

    public void delete(String id) {
        activityRepository.deleteById(id);
    }
}
