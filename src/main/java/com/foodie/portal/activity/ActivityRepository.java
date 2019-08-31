package com.foodie.portal.activity;

import com.fasterxml.jackson.core.type.TypeReference;
import com.foodie.portal.activity.repository.ActivityEntity;
import com.foodie.portal.activity.repository.ActivityEntityMapper;
import com.foodie.portal.activity.repository.ActivityJpaRepository;
import com.foodie.portal.city.repository.CityEntityMapper;
import com.foodie.portal.commons.Pagination;
import com.foodie.portal.commons.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class ActivityRepository {

    @Autowired
    private ActivityJpaRepository activityJpaRepository;



    public void save(Activity activity) {
        ActivityEntity activityEntity = ActivityEntityMapper.instance.from(activity);
//        activityEntity.setPriceList(JsonUtils.toJsonStr(activity.getPriceList()));
//        activityEntity.setServiceTime(JsonUtils.toJsonStr(activity.getServiceTime()));
        activityJpaRepository.save(activityEntity);
    }

    public Pagination<Activity> find(int pageIndex, int size) {
        Page<ActivityEntity> page = activityJpaRepository.findAll(PageRequest.of(pageIndex, size));

        return Pagination.<Activity>builder()
                .totalPages(page.getTotalPages())
                .total((int)page.getTotalElements())
                .current(page.getNumber())
                .pageSize(page.getSize())
                .content(page.getContent()
                        .stream().map(ActivityRepository::apply).collect(toList()))
                .build();
    }

    public Activity findById(String id) {
        return ActivityEntityMapper.instance.to(activityJpaRepository.getOne(id));
    }

    public void deleteById(String id) {
        activityJpaRepository.deleteById(id);
    }

    private static Activity apply(ActivityEntity activityEntity) {
        Activity activity = ActivityEntityMapper.instance.to(activityEntity);
//        activity.setPriceList(JsonUtils.toBean(activityEntity.getPriceList(), new TypeReference<List<ActivityPrice>>() {
//        }));
//        activity.setServiceTime(JsonUtils.toBean(activityEntity.getServiceTime(), new TypeReference<List<ActivityDateTime>>() {
//        }));
        return activity;
    }
}
