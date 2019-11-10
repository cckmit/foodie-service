package com.foodie.portal.activity.model;

import com.foodie.portal.commons.ErrorCode;
import com.foodie.portal.commons.RestException;
import com.foodie.portal.commons.utils.IdGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Objects;

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

    private ServiceScheduling(String id, String activityId, Date serviceDate, List<Shift> shifts) {
        this.id = Objects.isNull(id) ? IdGenerator.getId() : id;
        this.activityId = activityId;
        this.serviceDate = serviceDate;
        this.shifts = shifts;
    }

    public static ServiceScheduling create(String id, String activityId, Date serviceDate, List<Shift> shifts) {
        return new ServiceScheduling(id, activityId, serviceDate, shifts);
    }

    public void updateReserve(String startTime, int count, int maxPeopleLimit) {
        Shift shift = shifts.stream().filter(item -> item.getStartTime().equals(startTime))
                .findFirst()
                .orElseThrow(() -> new RestException(ErrorCode.FAILED, "没有排班时间段！"));
        if (shift.getReserveCount() + count > maxPeopleLimit) {
            throw new RestException(ErrorCode.FAILED, "超过最大人数限制");
        }
        shift.addReserveCount(count);
    }
}
