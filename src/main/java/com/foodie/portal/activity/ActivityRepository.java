package com.foodie.portal.activity;

import com.fasterxml.jackson.core.type.TypeReference;
import com.foodie.portal.activity.repository.ActivityEntity;
import com.foodie.portal.activity.repository.ActivityEntityMapper;
import com.foodie.portal.activity.repository.ActivityJpaRepository;
import com.foodie.portal.commons.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class ActivityRepository {

    @Autowired
    private ActivityJpaRepository activityJpaRepository;

    public void save(Activity activity) {
        ActivityEntity activityEntity = ActivityEntityMapper.instance.from(activity);
        activityEntity.setPriceList(JsonUtils.toJsonStr(activity.getPriceList()));
        activityEntity.setServiceTime(JsonUtils.toJsonStr(activity.getServiceTime()));
        activityJpaRepository.save(activityEntity);
    }

    public Collection<Activity> find() {
        return activityJpaRepository.findAll()
                .stream().map(activityEntity -> {
                    Activity activity = ActivityEntityMapper.instance.to(activityEntity);
                    activity.setPriceList(JsonUtils.toBean(activityEntity.getPriceList(), new TypeReference<List<ActivityPrice>>() {}));
                    activity.setServiceTime(JsonUtils.toBean(activityEntity.getServiceTime(), new TypeReference<List<ActivityDateTime>>() {}));
                    return activity;
                }).collect(toList());

    }
}
