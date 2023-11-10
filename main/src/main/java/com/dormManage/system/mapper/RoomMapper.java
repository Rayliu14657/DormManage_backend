package com.dormManage.system.mapper;

import com.dormManage.system.model.Room;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Rayliu
 * @since 2022-11-05
 */
@Mapper
public interface RoomMapper extends BaseMapper<Room> {

    int changeRoomStatus(int status,int roomId);

    Room selectRoom(int roomId);

    List<Room> selectAllRoom();

    List<Room> selectEmptyRoom();



}
