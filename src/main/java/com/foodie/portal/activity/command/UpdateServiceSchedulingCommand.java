package com.foodie.portal.activity.command;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UpdateServiceSchedulingCommand {

    private Date serviceDate;
    /**
     * 班次
     */
    private List<Shift> shifts;


    @Data
    public class Shift {
        private String startTime;
    }

}
