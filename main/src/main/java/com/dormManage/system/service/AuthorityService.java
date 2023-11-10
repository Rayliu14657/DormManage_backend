package com.dormManage.system.service;

import com.dormManage.system.model.Authority;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Rayliu
 * @since 2022-11-05
 */
public interface AuthorityService extends IService<Authority> {

    Authority getAuthority(int authorityId);

}
