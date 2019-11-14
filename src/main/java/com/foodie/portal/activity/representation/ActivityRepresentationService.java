package com.foodie.portal.activity.representation;

import com.foodie.portal.activity.model.ServiceScheduling;
import com.foodie.portal.activity.repository.ServiceSchedulingJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DomainActivityRepresentationService")
public class ActivityRepresentationService {

    @Autowired
    private ServiceSchedulingJpaRepository serviceSchedulingJpaRepository;

    public List<ServiceScheduling> findSchedulingByActivityAndYearMonth(String activityId, String yearMonth) {
        return ServiceSchedulingMapper.INSTANCE.to(serviceSchedulingJpaRepository.findByActivityIdAndServiceDateStartingWith(activityId, yearMonth));
    }
}
