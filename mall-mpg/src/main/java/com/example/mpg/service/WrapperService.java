package com.example.mpg.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

public interface WrapperService<T> {

    /**
     * 获取 QueryWrapper&lt;T&gt;
     *
     * @return QueryWrapper&lt;T&gt;
     */
    default QueryWrapper<T> queryWrapper() {
        return new QueryWrapper<>();
    }

    /**
     * 获取 QueryWrapper&lt;T&gt;
     *
     * @param entity 实体类
     * @return QueryWrapper&lt;T&gt;
     */
    default QueryWrapper<T> queryWrapper(T entity) {
        return new QueryWrapper<>(entity);
    }

    /**
     * 获取 LambdaQueryWrapper&lt;T&gt;
     *
     * @return LambdaQueryWrapper&lt;T&gt;
     */
    default LambdaQueryWrapper<T> lambdaQuery() {
        return new LambdaQueryWrapper<>();
    }

    /**
     * 获取 LambdaQueryWrapper&lt;T&gt;
     *
     * @param entity 实体类
     * @return LambdaQueryWrapper&lt;T&gt;
     */
    default LambdaQueryWrapper<T> lambdaQuery(T entity) {
        return new LambdaQueryWrapper<>(entity);
    }

    /**
     * 获取 LambdaQueryWrapper&lt;T&gt;
     *
     * @param entityClass 实体类class
     * @return LambdaQueryWrapper&lt;T&gt;
     * @since 3.3.1
     */
    default LambdaQueryWrapper<T> lambdaQuery(Class<T> entityClass) {
        return new LambdaQueryWrapper<>(entityClass);
    }

    /**
     * 获取 UpdateWrapper&lt;T&gt;
     *
     * @return UpdateWrapper&lt;T&gt;
     */
    default UpdateWrapper<T> updateWrapper() {
        return new UpdateWrapper<>();
    }

    /**
     * 获取 UpdateWrapper&lt;T&gt;
     *
     * @param entity 实体类
     * @return UpdateWrapper&lt;T&gt;
     */
    default UpdateWrapper<T> updateWrapper(T entity) {
        return new UpdateWrapper<>(entity);
    }

    /**
     * 获取 LambdaUpdateWrapper&lt;T&gt;
     *
     * @return LambdaUpdateWrapper&lt;T&gt;
     */
    default LambdaUpdateWrapper<T> lambdaUpdate() {
        return new LambdaUpdateWrapper<>();
    }

    /**
     * 获取 LambdaUpdateWrapper&lt;T&gt;
     *
     * @param entity 实体类
     * @return LambdaUpdateWrapper&lt;T&gt;
     */
    default LambdaUpdateWrapper<T> lambdaUpdate(T entity) {
        return new LambdaUpdateWrapper<>(entity);
    }

    /**
     * 获取 LambdaUpdateWrapper&lt;T&gt;
     *
     * @param entityClass 实体类class
     * @return LambdaUpdateWrapper&lt;T&gt;
     * @since 3.3.1
     */
    default LambdaUpdateWrapper<T> lambdaUpdate(Class<T> entityClass) {
        return new LambdaUpdateWrapper<>(entityClass);
    }

    /**
     * 获取 EmptyWrapper&lt;T&gt;
     *
     * @return EmptyWrapper&lt;T&gt;
     */
    default QueryWrapper<T> emptyWrapper() {
        return Wrappers.emptyWrapper();
    }
}
