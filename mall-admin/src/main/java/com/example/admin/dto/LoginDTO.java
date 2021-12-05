package com.example.admin.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginDTO {

    @NotBlank(message = "请输入用户名")
    private String username;
    @NotBlank(message = "请输入密码")
    private String password;
    @NotBlank(message = "验证码key不能为空")
    private String codeKey;
    @NotBlank(message = "请输入验证码")
    private String verifyCode;
}
