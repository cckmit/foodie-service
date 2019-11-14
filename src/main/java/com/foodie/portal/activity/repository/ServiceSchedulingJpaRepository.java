package com.foodie.portal.activity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServiceSchedulingJpaRepository extends JpaRepository<ServiceSchedulingEntity, String> {

    @Query("from ServiceSchedulingEntity where activityId=:activityId and str(serviceDate) like :serviceDate%")
    List<ServiceSchedulingEntity> findByActivityIdAndServiceDateStartingWith(@Param("activityId") String activityId, @Param("serviceDate") String serviceDate);
}
