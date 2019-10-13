package com.foodie.portal.activity;

import com.foodie.portal.activity.model.Activity;
import com.foodie.portal.activity.model.ActivityStatus;
import com.foodie.portal.activity.model.ActivityType;
import com.foodie.portal.activity.repository.ActivityEntity;
import com.foodie.portal.activity.repository.ActivityEntityMapper;
import com.foodie.portal.activity.repository.ActivityJpaRepository;
import com.foodie.portal.commons.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActivityRepository {

    @Autowired
    private ActivityJpaRepository activityJpaRepository;


    public void save(Activity activity) {
        ActivityEntity activityEntity = ActivityEntityMapper.instance.from(activity);
        activityJpaRepository.save(activityEntity);
    }

    public Pagination<Activity> find(int pageIndex, int size) {
        Page<ActivityEntity> page = activityJpaRepository.findAll(PageRequest.of(pageIndex, size));

        return ActivityEntityMapper.instance.to(page);
    }

    public Activity findById(String id) {
        return ActivityEntityMapper.instance.to(activityJpaRepository.getOne(id));
    }

    public void deleteById(String id) {
        activityJpaRepository.deleteById(id);
    }

    public Pagination<Activity> findNonApprovedActivities(int page, int size) {
        return ActivityEntityMapper.instance.to(activityJpaRepository.findByStatus(ActivityStatus.NON_APPROVE, PageRequest.of(page, size)));
    }

    public Pagination<Activity> findByMerchantId(String merchantId, int page, int size) {
        return ActivityEntityMapper.instance.to(activityJpaRepository.findByMerchantId(merchantId, PageRequest.of(page, size)));
    }

    public List<Activity> findByIds(List<String> ids) {
        return ActivityEntityMapper.instance.to(activityJpaRepository.findByIdIn(ids));
    }

    public List<Activity> findTopActivityByCityIdAndType(String cityId, ActivityType type, int limit) {
        return ActivityEntityMapper.instance.to(
                activityJpaRepository.findByCityIdAndType(cityId, type, PageRequest.of(0, limit))
                        .getContent());
    }


    public Pagination<Activity> findByCityId(int page, int size, String cityId) {
        return ActivityEntityMapper.instance.to(
                activityJpaRepository.findByCityId(cityId, PageRequest.of(page, size)));
    }
}
