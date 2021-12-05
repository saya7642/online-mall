package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author admin
 * @since 2021-11-23
 */
@Getter
@Setter
  @Accessors(chain = true)
  @TableName("t_index_config")
public class IndexConfig extends Model<IndexConfig> {

    private static final long serialVersionUID = 1L;

      /**
     * 首页配置项主键id
     */
        @TableId(value = "config_id", type = IdType.AUTO)
      private Long configId;

      /**
     * 显示字符(配置搜索时不可为空，其他可为空)
     */
      private String configName;

      /**
     * 1-搜索框热搜 2-搜索下拉框热搜 3-(首页)热销商品 4-(首页)新品上线 5-(首页)为你推荐
     */
      private Integer configType;

      /**
     * 商品id 默认为0
     */
      private Long goodsId;

      /**
     * 点击后的跳转地址(默认不跳转)
     */
      private String redirectUrl;

      /**
     * 排序值(字段越大越靠前)
     */
      private Integer configRank;

      /**
     * 删除标识字段(0-未删除 1-已删除)
     */
      private Integer isDeleted;

      /**
     * 创建时间
     */
      private LocalDateTime createTime;

      /**
     * 创建者id
     */
      private Integer createUser;

      /**
     * 最新修改时间
     */
      private LocalDateTime updateTime;

      /**
     * 修改者id
     */
      private Integer updateUser;


    @Override
    public Serializable pkVal() {
          return this.configId;
      }

}
