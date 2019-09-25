package com.foodie.portal.activity.model;

import com.foodie.portal.utils.IdGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class ServiceScheduling {

    private String id;
    private String activityId;
    private Date serviceDate;
    /**
     * 班次
     */
    private List<Shift> shifts;

    public ServiceScheduling(String activityId, Date serviceDate, List<Shift> shifts) {
        this.id = IdGenerator.getId();
        this.activityId = activityId;
        this.serviceDate = serviceDate;
        this.shifts = shifts;
    }

    public static ServiceScheduling create(String activityId, Date serviceDate, List<Shift> shifts) {
        return new ServiceScheduling(activityId, serviceDate, shifts);
    }


}
