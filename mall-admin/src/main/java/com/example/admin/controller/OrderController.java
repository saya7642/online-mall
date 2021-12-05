package com.example.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.api.R;
import com.example.mpg.base.BaseController;
import com.example.mpg.entity.Order;
import com.example.mpg.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
@Api(tags = "订单控制器")
public class OrderController extends BaseController {

    @Resource
    private OrderService orderService;

    @PostMapping
    @ApiOperation(value = "保存")
    public R save(@RequestBody Order order) {
        return R.success(orderService.save(order));
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public R update(@RequestBody Order order) {
        return R.success(orderService.updateById(order));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据id删除")
    public R delete(@PathVariable Long id) {
        Boolean res = orderService.removeById(id);
        return R.success(res);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id查询")
    public R findById(@PathVariable Long id) {
        return R.success(orderService.getById(id));
    }

    @GetMapping
    @ApiOperation(value = "查询所有")
    public R findAll() {
        return R.success(orderService.list());
    }

    @GetMapping("/page")
    @ApiOperation(value = "分页查询")
    public R findPage(@RequestParam(defaultValue = "") String name,
                      @RequestParam(defaultValue = "1") Integer pageNum,
                      @RequestParam(defaultValue = "10") Integer pageSize) {
        LambdaQueryWrapper<Order> wrapper = Wrappers.lambdaQuery();

        return R.success(orderService.page(new Page<>(pageNum, pageSize), wrapper));
    }
}
