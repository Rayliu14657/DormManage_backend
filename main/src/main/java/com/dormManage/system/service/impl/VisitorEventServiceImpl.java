package com.dormManage.system.service.impl;

import com.dormManage.system.model.VisitorEvent;
import com.dormManage.system.mapper.VisitorEventMapper;
import com.dormManage.system.service.VisitorEventService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Rayliu
 * @since 2022-11-05
 */
@Service
public class VisitorEventServiceImpl extends ServiceImpl<VisitorEventMapper, VisitorEvent> implements VisitorEventService {
    @Autowired
    private VisitorEventMapper visitorEventMapper;

    @Override
    public VisitorEvent selectVisitorEventById(int id) {
        return visitorEventMapper.selectVisitorEventById(id);
    }

    @Override
    public int insertVisitorEvent(VisitorEvent visitorEvent) {
        return visitorEventMapper.insertVisitorEvent(visitorEvent);
    }

    @Override
    public int deleteVisitorEvent(int id) {
        return visitorEventMapper.deleteVisitorEvent(id);
    }

    @Override
    public int updateVisitorEvent(VisitorEvent visitorEvent) {
        return visitorEventMapper.updateVisitorEvent(visitorEvent);
    }

}
