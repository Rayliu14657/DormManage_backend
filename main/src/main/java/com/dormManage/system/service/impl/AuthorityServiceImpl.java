package com.dormManage.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dormManage.system.model.Authority;
import com.dormManage.system.mapper.AuthorityMapper;
import com.dormManage.system.service.AuthorityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Rayliu
 * @since 2022-11-05
 */
@Service
public class AuthorityServiceImpl extends ServiceImpl<AuthorityMapper, Authority> implements AuthorityService {

    @Override
    public Authority getAuthority(int authorityId) {
        QueryWrapper<Authority> wrapper1=new QueryWrapper<>();
        List<Authority> authorityList=new ArrayList<>();
        wrapper1.eq("authority_id",authorityId);
        Authority authority =  baseMapper.selectById(authorityId);
        return authority;
    }
}
