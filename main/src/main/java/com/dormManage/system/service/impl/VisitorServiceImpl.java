package com.dormManage.system.service.impl;

import com.dormManage.system.model.Visitor;
import com.dormManage.system.mapper.VisitorMapper;
import com.dormManage.system.service.VisitorService;
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
public class VisitorServiceImpl extends ServiceImpl<VisitorMapper, Visitor> implements VisitorService {
    @Autowired
    private VisitorMapper visitorMapper;

    @Override
    public Visitor selectVisitorById(int id) {
        return visitorMapper.selectVisitorById(id);
    }

    @Override
    public int insertVisitor(Visitor visitor) {
        return visitorMapper.insertVisitor(visitor);

    }

    @Override
    public int deleteVisitor(int id) {
        return visitorMapper.deleteVisitor(id);

    }

    @Override
    public int updateVisitor(Visitor visitor) {
        return visitorMapper.updateVisitor(visitor);
    }

}
