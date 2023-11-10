package com.dormManage.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dormManage.common.result.RestResult;
import com.dormManage.system.model.Room;
import com.dormManage.system.mapper.RoomMapper;
import com.dormManage.system.service.RoomService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.models.auth.In;
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
public class RoomServiceImpl extends ServiceImpl<RoomMapper, Room> implements RoomService {

    @Override
    public Integer findVacant() {
            QueryWrapper<Room> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("is_vacant",1).last("limit 1");
            if(baseMapper.selectOne(queryWrapper)==null){
                return null;
            }
            Room roomRes=baseMapper.selectOne(queryWrapper);
            roomRes.setIsVacant(0);
            baseMapper.updateById(roomRes);
            return roomRes.getRoomId();
    }
}
