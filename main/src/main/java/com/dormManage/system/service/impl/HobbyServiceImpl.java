package com.dormManage.system.service.impl;

import com.dormManage.common.result.RestResult;
import com.dormManage.system.model.Hobby;
import com.dormManage.system.mapper.HobbyMapper;
import com.dormManage.system.service.HobbyService;
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
public class HobbyServiceImpl extends ServiceImpl<HobbyMapper, Hobby> implements HobbyService {

    @Override
    public List<Hobby> getHobbyList() {
        List<Hobby> hobbyList= baseMapper.selectByMap(null);

        return hobbyList;

    }
}
