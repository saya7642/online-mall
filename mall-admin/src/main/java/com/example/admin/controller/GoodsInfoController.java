package com.example.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.api.R;
import com.example.mpg.base.BaseController;
import com.example.mpg.entity.GoodsInfo;
import com.example.mpg.service.GoodsInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/goodsInfo")
@Api(tags = "商品信息控制器")
public class GoodsInfoController extends BaseController {

    @Resource
    private GoodsInfoService goodsInfoService;

    @PostMapping
    @ApiOperation(value = "保存")
    public R save(@RequestBody GoodsInfo goodsInfo) {
        return R.success(goodsInfoService.save(goodsInfo));
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public R update(@RequestBody GoodsInfo goodsInfo) {
        return R.success(goodsInfoService.updateById(goodsInfo));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据id删除")
    public R delete(@PathVariable Long id) {
        Boolean res = goodsInfoService.removeById(id);
        return R.success(res);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id查询")
    public R findById(@PathVariable Long id) {
        return R.success(goodsInfoService.getById(id));
    }

    @GetMapping
    @ApiOperation(value = "查询所有")
    public R findAll() {
        return R.success(goodsInfoService.list());
    }

    @GetMapping("/page")
    @ApiOperation(value = "分页查询")
    public R findPage(@RequestParam(defaultValue = "") String name,
                      @RequestParam(defaultValue = "1") Integer pageNum,
                      @RequestParam(defaultValue = "10") Integer pageSize) {
        LambdaQueryWrapper<GoodsInfo> wrapper = Wrappers.lambdaQuery();

        return R.success(goodsInfoService.page(new Page<>(pageNum, pageSize), wrapper));
    }
}
