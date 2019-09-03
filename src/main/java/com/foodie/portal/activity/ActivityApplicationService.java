package com.foodie.portal.activity;

import com.foodie.portal.activity.model.Activity;
import com.foodie.portal.city.CityApplicationService;
import com.foodie.portal.commons.Pagination;
import com.foodie.portal.user.model.Merchant;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityApplicationService {

    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private CityApplicationService cityApplicationService;

    public void addActivity(CreateActivityCommand activityCommand) {
        addActivity(activityCommand, null);
    }

    public void addActivity(CreateActivityCommand command, Merchant merchant) {
        var city = cityApplicationService.retrieve(command.getCityId());
        var activity = Activity.create(command.getTitle(), command.getSubTitle(),
                command.getDescription(), command.getCategory(), command.getDuration(),
                command.getMaxPeopleLimit(), command.getImages(), command.getLanguage(),
                command.getAddress(), city,  command.getCostList(),
                command.getDates(), command.getType());
        activity.setMerchant(merchant);
        activityRepository.save(activity);
    }

    public Pagination<Activity> find(int page, int size) {
        return activityRepository.find(page - 1, size);
    }

    public Activity findById(String id) {
        return activityRepository.findById(id);
    }

    public void updateActivity(String id, UpdateActivityCommand command) {
        Activity activity = activityRepository.findById(id);
        activity.update(command.getTitle(), command.getSubTitle(),
                command.getDescription(), command.getCategory(), command.getDuration(),
                command.getMaxPeopleLimit(), command.getImages(), command.getLanguage(),
                command.getAddress(), command.getCostList(),
                command.getDates());
        activityRepository.save(activity);
    }

    public void delete(String id) {
        activityRepository.deleteById(id);
    }

    public void pass(String id) {
        var activity = activityRepository.findById(id);
        activity.pass();
        activityRepository.save(activity);
    }

    public Pagination<Activity> waitForApprovedActivities(int page, int size) {
        return activityRepository.findNonApprovedActivities(page - 1, size);
    }

    public void reject(String id) {
        var activity = activityRepository.findById(id);
        activity.reject();
        activityRepository.save(activity);
    }


    public Pagination<Activity> findOwnerActivity(String merchantId, int page, int size) {
        return activityRepository.findByMerchantId(merchantId, page - 1, size);
    }

    public List<Activity> fetchActivitiesByIds(List<String> ids) {
        return activityRepository.fetchActivitiesByIds(ids);
    }

    public List<Activity> topCityActivities(String cityId, int limit) {
        return activityRepository.findTopActivityByCityId(cityId, limit);
    }
}
