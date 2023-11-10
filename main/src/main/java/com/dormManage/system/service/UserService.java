package com.dormManage.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dormManage.common.result.RestResult;
import com.dormManage.system.model.User;

public interface UserService extends IService<User> {
    RestResult findAllUsersByPage(int current, int limit);

    User login(User loginUser);
}
