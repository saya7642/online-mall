package com.example.admin.controller;

import com.example.common.api.R;
import com.example.admin.dto.LoginDTO;
import com.example.mpg.base.BaseController;
import com.example.mpg.entity.AdminUser;
import com.example.mpg.service.AdminUserService;
import com.example.mpg.service.CaptchaService;
import com.wf.captcha.utils.CaptchaUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/anno")
@Api(tags = "登录控制器")
public class LoginController extends BaseController {

    @Resource
    private AdminUserService adminUserService;
    @Resource
    private CaptchaService loginService;

    @PostMapping("/login")
    @ApiOperation(value = "管理员登录")
    public R adminLogin(@Validated @RequestBody LoginDTO loginDTO) {
        loginService.check(loginDTO.getCodeKey(), loginDTO.getVerifyCode());
        AdminUser admin = adminUserService.login(loginDTO.getUsername(), loginDTO.getPassword());
        return R.success(admin, "登录成功");
    }

    @GetMapping(value = "/captcha", produces = "image/png")
    @ApiOperation(value = "生成验证码")
    public void captcha(String key, HttpServletResponse response) throws IOException {
        CaptchaUtil.setHeader(response);
        loginService.createCaptcha(key, response.getOutputStream());
    }
}
