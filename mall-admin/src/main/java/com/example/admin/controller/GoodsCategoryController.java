package com.example.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.api.R;
import com.example.mpg.base.BaseController;
import com.example.mpg.entity.GoodsCategory;
import com.example.mpg.service.GoodsCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/goodsCategory")
@Api(tags = "商品分类控制器")
public class GoodsCategoryController extends BaseController {

    @Resource
    private GoodsCategoryService goodsCategoryService;

    @PostMapping
    @ApiOperation(value = "保存")
    public R save(@RequestBody GoodsCategory goodsCategory) {
        return R.success(goodsCategoryService.save(goodsCategory));
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public R update(@RequestBody GoodsCategory goodsCategory) {
        return R.success(goodsCategoryService.updateById(goodsCategory));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据id删除")
    public R delete(@PathVariable Long id) {
        Boolean res = goodsCategoryService.removeById(id);
        return R.success(res);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id查询")
    public R findById(@PathVariable Long id) {
        return R.success(goodsCategoryService.getById(id));
    }

    @GetMapping
    @ApiOperation(value = "查询所有")
    public R findAll() {
        return R.success(goodsCategoryService.list());
    }

    @GetMapping("/page")
    @ApiOperation(value = "分页查询")
    public R findPage(@RequestParam(defaultValue = "") String name,
                      @RequestParam(defaultValue = "1") Integer pageNum,
                      @RequestParam(defaultValue = "10") Integer pageSize) {
        LambdaQueryWrapper<GoodsCategory> wrapper = Wrappers.lambdaQuery();

        return R.success(goodsCategoryService.page(new Page<>(pageNum, pageSize), wrapper));
    }
}
