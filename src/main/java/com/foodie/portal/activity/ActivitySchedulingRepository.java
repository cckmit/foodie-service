package com.foodie.portal.activity;

import com.foodie.portal.activity.model.Activity;
import com.foodie.portal.activity.model.ActivityStatus;
import com.foodie.portal.activity.model.ServiceScheduling;
import com.foodie.portal.activity.repository.*;
import com.foodie.portal.commons.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActivitySchedulingRepository {

    @Autowired
    private ServiceSchedulingJpaRepository serviceSchedulingJpaRepository;


    public void save(List<ServiceScheduling> serviceScheduling) {
        serviceSchedulingJpaRepository.saveAll(ServiceSchedulingEntityMapper.instance.from(serviceScheduling));
    }

    public void delete(List<ServiceScheduling> serviceScheduling) {
        serviceSchedulingJpaRepository.deleteAll(ServiceSchedulingEntityMapper.instance.from(serviceScheduling));
    }


}
