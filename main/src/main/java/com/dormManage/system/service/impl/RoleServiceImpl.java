package com.dormManage.system.service.impl;

import com.dormManage.system.model.Role;
import com.dormManage.system.mapper.RoleMapper;
import com.dormManage.system.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Override
    public List<Role> getAllRoles() {
        return baseMapper.selectByMap(null);
    }
}
