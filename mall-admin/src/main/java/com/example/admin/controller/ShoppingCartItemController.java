package com.example.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.api.R;
import com.example.mpg.base.BaseController;
import com.example.mpg.entity.ShoppingCartItem;
import com.example.mpg.service.ShoppingCartItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/cartItem")
@Api(tags = "购物车控制器")
public class ShoppingCartItemController extends BaseController {

    @Resource
    private ShoppingCartItemService shoppingCartItemService;

    @PostMapping
    @ApiOperation(value = "保存")
    public R save(@RequestBody ShoppingCartItem shoppingCartItem) {
        return R.success(shoppingCartItemService.save(shoppingCartItem));
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public R update(@RequestBody ShoppingCartItem shoppingCartItem) {
        return R.success(shoppingCartItemService.updateById(shoppingCartItem));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据id删除")
    public R delete(@PathVariable Long id) {
        Boolean res = shoppingCartItemService.removeById(id);
        return R.success(res);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id查询")
    public R findById(@PathVariable Long id) {
        return R.success(shoppingCartItemService.getById(id));
    }

    @GetMapping
    @ApiOperation(value = "查询所有")
    public R findAll() {
        return R.success(shoppingCartItemService.list());
    }

    @GetMapping("/page")
    @ApiOperation(value = "分页查询")
    public R findPage(@RequestParam(defaultValue = "") String name,
                      @RequestParam(defaultValue = "1") Integer pageNum,
                      @RequestParam(defaultValue = "10") Integer pageSize) {
        LambdaQueryWrapper<ShoppingCartItem> wrapper = Wrappers.lambdaQuery();

        return R.success(shoppingCartItemService.page(new Page<>(pageNum, pageSize), wrapper));
    }
}
