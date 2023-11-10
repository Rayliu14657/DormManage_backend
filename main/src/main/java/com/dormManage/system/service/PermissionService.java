package com.dormManage.system.service;

import com.dormManage.system.model.Authority;
import com.dormManage.system.model.Permission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Rayliu
 * @since 2022-11-05
 */
public interface PermissionService extends IService<Permission> {
    List<Permission> getPermissions(int roleId);



}
