package com.example.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.api.R;
import com.example.mpg.base.BaseController;
import com.example.mpg.entity.OrderItem;
import com.example.mpg.service.OrderItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/orderItem")
@Api(tags = "订单项控制器")
public class OrderItemController extends BaseController {

    @Resource
    private OrderItemService orderItemService;

    @PostMapping
    @ApiOperation(value = "保存")
    public R save(@RequestBody OrderItem orderItem) {
        return R.success(orderItemService.save(orderItem));
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public R update(@RequestBody OrderItem orderItem) {
        return R.success(orderItemService.updateById(orderItem));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据id删除")
    public R delete(@PathVariable Long id) {
        Boolean res = orderItemService.removeById(id);
        return R.success(res);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id查询")
    public R findById(@PathVariable Long id) {
        return R.success(orderItemService.getById(id));
    }

    @GetMapping
    @ApiOperation(value = "查询所有")
    public R findAll() {
        return R.success(orderItemService.list());
    }

    @GetMapping("/page")
    @ApiOperation(value = "分页查询")
    public R findPage(@RequestParam(defaultValue = "") String name,
                      @RequestParam(defaultValue = "1") Integer pageNum,
                      @RequestParam(defaultValue = "10") Integer pageSize) {
        LambdaQueryWrapper<OrderItem> wrapper = Wrappers.lambdaQuery();

        return R.success(orderItemService.page(new Page<>(pageNum, pageSize), wrapper));
    }
}
