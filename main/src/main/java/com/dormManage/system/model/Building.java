package com.dormManage.system.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Authority对象", description="")
public class Building implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value="building_id",type= IdType.AUTO)
    private Integer buildingId;

    private String  buildingName;
}
