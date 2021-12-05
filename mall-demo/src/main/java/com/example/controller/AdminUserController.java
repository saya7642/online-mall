package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import com.example.mpg.base.BaseController;
import com.example.common.api.R;
import com.example.mpg.entity.AdminUser;
import com.example.mpg.service.AdminUserService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/adminUser")
@Api(tags = "管理员用户控制器")
public class AdminUserController extends BaseController {

    @Resource
    private AdminUserService adminUserService;

    @PostMapping
    @ApiOperation(value = "保存")
    public R save(@RequestBody AdminUser adminUser) {
        return R.success(adminUserService.save(adminUser));
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public R update(@RequestBody AdminUser adminUser) {
        return R.success(adminUserService.updateById(adminUser));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据id删除")
    public R delete(@PathVariable Long id) {
        Boolean res = adminUserService.removeById(id);
        return R.success(res);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id查询")
    public R findById(@PathVariable Long id) {
        return R.success(adminUserService.getById(id));
    }

    @GetMapping
    @ApiOperation(value = "查询所有")
    public R findAll() {
        return R.success(adminUserService.list());
    }

    @GetMapping("/page")
    @ApiOperation(value = "分页查询")
    public R findPage(@RequestParam(defaultValue = "") String name,
                      @RequestParam(defaultValue = "1") Integer pageNum,
                      @RequestParam(defaultValue = "10") Integer pageSize) {
        LambdaQueryWrapper<AdminUser> wrapper = Wrappers.lambdaQuery();

        return R.success(adminUserService.page(new Page<>(pageNum, pageSize), wrapper));
    }
}
