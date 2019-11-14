package com.foodie.portal.activity.command;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@ApiModel
public class UpdateServiceSchedulingCommand {

    private List<ServiceScheduling> save;
    private List<ServiceScheduling> delete;


    @ApiModel
    @Data
    public static class ShiftCommand {
        @ApiModelProperty("开始时间")
        private String startTime;
    }


    @Data
    public static class ServiceScheduling{
        private String id;
        private Date serviceDate;
        /**
         * 班次
         */
        private List<ShiftCommand> shifts;
    }

}
