package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import com.example.mpg.base.BaseController;
import com.example.common.api.R;
import com.example.mpg.entity.IndexConfig;
import com.example.mpg.service.IndexConfigService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/indexConfig")
@Api(tags = "")
public class IndexConfigController extends BaseController {

    @Resource
    private IndexConfigService indexConfigService;

    @PostMapping
    @ApiOperation(value = "保存")
    public R save(@RequestBody IndexConfig indexConfig) {
        return R.success(indexConfigService.save(indexConfig));
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public R update(@RequestBody IndexConfig indexConfig) {
        return R.success(indexConfigService.updateById(indexConfig));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据id删除")
    public R delete(@PathVariable Long id) {
        Boolean res = indexConfigService.removeById(id);
        return R.success(res);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id查询")
    public R findById(@PathVariable Long id) {
        return R.success(indexConfigService.getById(id));
    }

    @GetMapping
    @ApiOperation(value = "查询所有")
    public R findAll() {
        return R.success(indexConfigService.list());
    }

    @GetMapping("/page")
    @ApiOperation(value = "分页查询")
    public R findPage(@RequestParam(defaultValue = "") String name,
                      @RequestParam(defaultValue = "1") Integer pageNum,
                      @RequestParam(defaultValue = "10") Integer pageSize) {
        LambdaQueryWrapper<IndexConfig> wrapper = Wrappers.lambdaQuery();

        return R.success(indexConfigService.page(new Page<>(pageNum, pageSize), wrapper));
    }
}
