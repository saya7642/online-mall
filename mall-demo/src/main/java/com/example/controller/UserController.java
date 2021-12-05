package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import com.example.mpg.base.BaseController;
import com.example.common.api.R;
import com.example.mpg.entity.User;
import com.example.mpg.service.UserService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
@Api(tags = "")
public class UserController extends BaseController {

    @Resource
    private UserService userService;

    @PostMapping
    @ApiOperation(value = "保存")
    public R save(@RequestBody User user) {
        return R.success(userService.save(user));
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public R update(@RequestBody User user) {
        return R.success(userService.updateById(user));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据id删除")
    public R delete(@PathVariable Long id) {
        Boolean res = userService.removeById(id);
        return R.success(res);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id查询")
    public R findById(@PathVariable Long id) {
        return R.success(userService.getById(id));
    }

    @GetMapping
    @ApiOperation(value = "查询所有")
    public R findAll() {
        return R.success(userService.list());
    }

    @GetMapping("/page")
    @ApiOperation(value = "分页查询")
    public R findPage(@RequestParam(defaultValue = "") String name,
                      @RequestParam(defaultValue = "1") Integer pageNum,
                      @RequestParam(defaultValue = "10") Integer pageSize) {
        LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery();

        return R.success(userService.page(new Page<>(pageNum, pageSize), wrapper));
    }
}
