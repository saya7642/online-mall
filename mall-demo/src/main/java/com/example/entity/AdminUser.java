package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
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
  @TableName("t_admin_user")
public class AdminUser extends Model<AdminUser> {

    private static final long serialVersionUID = 1L;

      /**
     * 管理员id
     */
        @TableId(value = "admin_user_id", type = IdType.AUTO)
      private Integer adminUserId;

      /**
     * 管理员登陆名称
     */
      private String loginUserName;

      /**
     * 管理员登陆密码
     */
      private String loginPassword;

      /**
     * 管理员显示昵称
     */
      private String nickName;

      /**
     * 是否锁定 0未锁定 1已锁定无法登陆
     */
      private Integer locked;


    @Override
    public Serializable pkVal() {
          return this.adminUserId;
      }

}
