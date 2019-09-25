package com.foodie.portal.activity.repository;

import com.foodie.portal.activity.model.Shift;
import lombok.Data;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "foodie_service_scheduling")
public class ServiceSchedulingEntity implements Serializable {

    @Id
    private String id;
    private String activityId;
    private Date serviceDate;
    /**
     * 班次
     */
    @Convert(converter = ListShiftConverter.class)
    private List<Shift> shifts;
}
