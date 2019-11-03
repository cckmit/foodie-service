package com.foodie.portal.activity.model;

import com.foodie.portal.commons.ErrorCode;
import com.foodie.portal.commons.RestException;
import com.foodie.portal.commons.utils.IdGenerator;
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

    private ServiceScheduling(String activityId, Date serviceDate, List<Shift> shifts) {
        this.id = IdGenerator.getId();
        this.activityId = activityId;
        this.serviceDate = serviceDate;
        this.shifts = shifts;
    }

    public static ServiceScheduling create(String activityId, Date serviceDate, List<Shift> shifts) {
        return new ServiceScheduling(activityId, serviceDate, shifts);
    }

    public void updateReserve(String startTime, int count, int maxPeopleLimit) {
        Shift shift = shifts.stream().filter(item -> item.getStartTime().equals(startTime))
                .findFirst()
                .orElseThrow(() -> new RestException(ErrorCode.FAILED, "没有排班时间段！"));
        if(shift.getReserveCount() + count > maxPeopleLimit) {
            throw new RestException(ErrorCode.FAILED, "超过最大人数限制");
        }
        shift.addReserveCount(count);
    }
}
