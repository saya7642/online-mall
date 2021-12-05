package com.example.generator.template;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.api.R;
import com.example.mpg.entity.AdminUser;
import com.example.mpg.service.AdminUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RequestMapping("/admin/adminUser")
public class TemplateController {

    @Resource
    private AdminUserService adminUserService;

    @PostMapping
    public R save(@RequestBody AdminUser adminUser) {
        return R.success(adminUserService.save(adminUser));
    }

    @PutMapping
    public R update(@RequestBody AdminUser adminUser) {
        return R.success(adminUserService.updateById(adminUser));
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Long id) {
        Boolean res = adminUserService.removeById(id);
        return R.success(res);
    }

    @GetMapping("/{id}")
    public R findById(@PathVariable Long id) {
        return R.success(adminUserService.getById(id));
    }

    @GetMapping
    public R findAll() {
        return R.success(adminUserService.list());
    }

    @GetMapping("/page")
    public R findPage(@RequestParam(defaultValue = "") String name,
                      @RequestParam(defaultValue = "1") Integer pageNum,
                      @RequestParam(defaultValue = "10") Integer pageSize) {
        LambdaQueryWrapper<AdminUser> wrapper = Wrappers.lambdaQuery();

        return R.success(adminUserService.page(new Page<>(pageNum, pageSize), wrapper));
    }
}
