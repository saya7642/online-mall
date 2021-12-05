package com.example.mpg.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import com.example.mpg.base.BaseController;
import com.example.common.api.R;
import com.example.mpg.entity.${cfg.entityUpper};
import com.example.mpg.service.${cfg.entityUpper}Service;

import javax.annotation.Resource;

@RestController
@RequestMapping("/${cfg.entityLower}")
public class ${cfg.entityUpper}Controller {

    @Resource
    private ${cfg.entityUpper}Service ${cfg.entityLower}Service;

    @PostMapping
    public R save(@RequestBody ${cfg.entityUpper} ${cfg.entityLower}) {
        return R.success(${cfg.entityLower}Service.save(${cfg.entityLower}));
    }

    @PutMapping
    public R update(@RequestBody ${cfg.entityUpper} ${cfg.entityLower}) {
        return R.success(${cfg.entityLower}Service.updateById(${cfg.entityLower}));
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Long id) {
        ${cfg.entityLower}Service.removeById(id);
        return R.success();
    }

    @GetMapping("/{id}")
    public R findById(@PathVariable Long id) {
        return R.success(${cfg.entityLower}Service.getById(id));
    }

    @GetMapping
    public R findAll() {
        return R.success(${cfg.entityLower}Service.list());
    }

    @GetMapping("/page")
    public R findPage(@RequestParam(defaultValue = "") String name,
                      @RequestParam(defaultValue = "1") Integer pageNum,
                      @RequestParam(defaultValue = "10") Integer pageSize) {
        LambdaQueryWrapper<${cfg.entityUpper}> wrapper = Wrappers.lambdaQuery();

        return R.success(${cfg.entityLower}Service.page(new Page<>(pageNum, pageSize), wrapper));
    }
}
