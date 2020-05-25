package com.Ace.Vshop.controller;

import com.Ace.Vshop.common.api.CommonResult;
import com.Ace.Vshop.dto.UmsAdminParam;
import com.Ace.Vshop.model.UmsAdmin;
import com.Ace.Vshop.service.UmsAdminService;
import com.Ace.Vshop.service.UmsRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Api(tags = "UmsAdminController")
@RequestMapping(value = "/admin")
public class UmsAdminController {
    //token配置
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private UmsAdminService adminService;
    @Autowired
    private UmsRoleService roleService;

    //用户注册
    @ApiOperation(value="用户注册")
    @RequestMapping(value="/register", method = RequestMethod.POST)
    public CommonResult<UmsAdmin> register(@RequestBody UmsAdminParam umsAdminParam, BindingResult result){
        UmsAdmin umsAdmin = adminService.register(umsAdminParam);

        if(umsAdmin == null){
            CommonResult.faild();
        }

        return CommonResult.success(umsAdmin);
    }

    //登录以后返回token

    //刷新token

    //获取当前登录用户信息

    //登出

    //获取指定用户信息

    //修改指定用户信息

    //修改指定用户密码

    //删除指定用户信息

    //修改账户状态

    //给用户分配角色

    //获取指定用户角色

    //用户+-权限

    //获取用户所有权限（包括+-权限）
}
