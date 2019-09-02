package com.foodie.portal.order;

import com.foodie.portal.commons.PageCommand;
import com.foodie.portal.commons.Pagination;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "（管理员）订单管理")
@RestController
@RequestMapping("order")
public class AdminOrderController {

    @Autowired
    private OrderApplicationService orderApplicationService;

    @ApiOperation("订单列表")
    @GetMapping
    public Pagination<Order> orders(PageCommand command) {
        return orderApplicationService.findByPage(command.getPage(), command.getSize());
    }

}
