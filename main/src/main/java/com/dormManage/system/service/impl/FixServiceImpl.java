package com.dormManage.system.service.impl;

import com.dormManage.system.model.Fix;
import com.dormManage.system.mapper.FixMapper;
import com.dormManage.system.service.FixService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class FixServiceImpl extends ServiceImpl<FixMapper, Fix> implements FixService {
    @Autowired
    FixMapper fixMapper;
    @Override
    public List<Fix> selectAllFix(){return fixMapper.selectAllFix();}//有无selectAll的basemapper?
    @Override
    public Fix selectFixByRoomId(int id){return fixMapper.selectFixByRoomId(id);}
    @Override
    public int insertFix(Fix fix){return fixMapper.insertFix(fix);}
    @Override
    public int updateFix(Fix fix){return fixMapper.updateFix(fix);};
    @Override
    public int deleteFix(int id){return fixMapper.deleteFix(id);};

}
