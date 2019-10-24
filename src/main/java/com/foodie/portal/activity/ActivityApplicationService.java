package com.foodie.portal.activity;

import com.foodie.portal.activity.command.AdminCreateActivityCommand;
import com.foodie.portal.activity.command.CreateActivityCommand;
import com.foodie.portal.activity.command.UpdateActivityCommand;
import com.foodie.portal.activity.command.UpdateServiceSchedulingCommand;
import com.foodie.portal.activity.model.Activity;
import com.foodie.portal.activity.model.ServiceScheduling;
import com.foodie.portal.activity.model.Shift;
import com.foodie.portal.city.CityApplicationService;
import com.foodie.portal.commons.Pagination;
import com.foodie.portal.user.MerchantApplicationService;
import com.foodie.portal.user.model.Merchant;
import lombok.var;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityApplicationService {

    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private CityApplicationService cityApplicationService;
    @Autowired
    private MerchantApplicationService merchantApplicationService;

    public void addActivity(AdminCreateActivityCommand command) {
        var merchant = merchantApplicationService.findById(command.getMerchantId());
        addActivity(command, merchant);
    }

    public void addActivity(CreateActivityCommand command, Merchant merchant) {
        var city = cityApplicationService.retrieve(command.getCityId());
        var activity = Activity.create(command.getTitle(), command.getSubTitle(),
                command.getDescription(), command.getDuration(),
                command.getMaxPeopleLimit(), command.getImages(), command.getLanguage(),
                command.getAddress(), city, command.getCostList(), command.getType());
        activity.setMerchant(merchant);
        activityRepository.save(activity);
    }

    public Pagination<Activity> find(int page, int size) {
        return find(page, size, null);
    }

    public Pagination<Activity> find(int page, int size, String cityId) {
        if(Strings.isBlank(cityId)) {
            return activityRepository.find(page - 1, size);
        }else {
            return activityRepository.findByCityId(page-1, size, cityId);
        }

    }

    public Activity findById(String id) {
        return activityRepository.findById(id);
    }

    public void updateActivity(String id, UpdateActivityCommand command) {
        Activity activity = activityRepository.findById(id);
        var city = cityApplicationService.retrieve(command.getCityId());
        activity.update(command.getTitle(), command.getSubTitle(),
                command.getDescription(), command.getDuration(),
                command.getMaxPeopleLimit(), command.getImages(), command.getLanguage(),
                command.getAddress(), command.getCostList(), city);
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
        return activityRepository.findByIds(ids);
    }


    public void updateServiceScheduling(String id, List<UpdateServiceSchedulingCommand> command) {
        List<ServiceScheduling> serviceSchedulingList = command.stream()
                .map(item -> ServiceScheduling.create(id, item.getServiceDate(),
                        item.getShifts().stream().map(shift -> Shift.create(shift.getStartTime())).collect(Collectors.toList())))
                .collect(Collectors.toList());
        Activity activity = activityRepository.findById(id);

        activity.updateScheduling(serviceSchedulingList);
        activityRepository.save(activity);
    }

    public void updateReserve(String id, String serviceDate, String startTime, int count) {
        Activity activity = activityRepository.findById(id);
        activity.updateReserve(serviceDate, startTime, count);
        activityRepository.save(activity);
    }
}
