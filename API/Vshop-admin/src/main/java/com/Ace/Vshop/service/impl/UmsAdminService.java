package com.Ace.Vshop.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.Ace.Vshop.dto.UmsAdminParam;
import com.Ace.Vshop.mapper.UmsAdminMapper;
import com.Ace.Vshop.model.UmsAdmin;
import com.Ace.Vshop.model.UmsAdminExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.List;

public class UmsAdminService implements com.Ace.Vshop.service.UmsAdminService {
    /***
     * MyBatis映射文件
     */
    @Autowired
    private UmsAdminMapper adminMapper;

    /***
     * 密码加密
     */
    @Autowired
    private PasswordEncoder passwordEnCoder;

    /***
     * 注册功能
     * @param umsAdminParam
     * @return
     */
    @Override
    public UmsAdmin register(UmsAdminParam umsAdminParam) {
        UmsAdmin umsAdmin = new UmsAdmin();
        /***
         * static void copyProperties(Object source, Object target)
         * 实现深拷贝
         * source=>target
         */
        BeanUtil.copyProperties(umsAdminParam,umsAdmin);

        umsAdmin.setCreateTime(new Date());
        umsAdmin.setStatus(1);

        //查询是否存在相同用户
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(umsAdmin.getUsername());
        List<UmsAdmin> umsAdminList = adminMapper.selectByExample(example);
        if(umsAdminList.size()>0){
            return null;
        }

        //密码进行加密操作
        String encodePassword = passwordEnCoder.encode(umsAdmin.getPassword());
        umsAdmin.setPassword(encodePassword);

        adminMapper.insert(umsAdmin);

        return umsAdmin;
    }
}
