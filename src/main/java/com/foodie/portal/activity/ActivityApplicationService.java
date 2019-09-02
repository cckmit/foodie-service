package com.foodie.portal.activity;

import com.foodie.portal.commons.Pagination;
import com.foodie.portal.merchant.Merchant;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityApplicationService {

    @Autowired
    private ActivityRepository activityRepository;

    public void addActivity(CreateActivityCommand activityCommand) {
        addActivity(activityCommand, null);
    }

    public void addActivity(CreateActivityCommand activityCommand, Merchant merchant) {
        var activity = Activity.create(activityCommand.getTitle(),activityCommand.getSubTitle(),
                activityCommand.getDescription(),activityCommand.getCategory(),activityCommand.getDuration(),
                activityCommand.getMaxPeopleLimit(),activityCommand.getImages(),activityCommand.getLanguage(),
                activityCommand.getAddress(),activityCommand.getCityId(),activityCommand.getCityName(),activityCommand.getCostList(),
                activityCommand.getDates());
        activity.setMerchant(merchant);
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
                activityCommand.getDescription(),activityCommand.getCategory(),activityCommand.getDuration(),
                activityCommand.getMaxPeopleLimit(),activityCommand.getImages(),activityCommand.getLanguage(),
                activityCommand.getAddress(),activityCommand.getCityId(),activityCommand.getCityName(),activityCommand.getCostList(),
                activityCommand.getDates());
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
}
