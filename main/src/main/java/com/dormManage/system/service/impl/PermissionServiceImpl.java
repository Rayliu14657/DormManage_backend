package com.dormManage.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dormManage.system.model.Authority;
import com.dormManage.system.model.Permission;
import com.dormManage.system.mapper.PermissionMapper;
import com.dormManage.system.service.PermissionService;
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
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {
    @Override
    public List<Permission> getPermissions(int roleId) {
        QueryWrapper<Permission> wrapper = new QueryWrapper<>();
        wrapper.eq("role_id", roleId);
        return baseMapper.selectList(wrapper);
    }


}
