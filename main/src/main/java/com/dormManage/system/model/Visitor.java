package com.dormManage.system.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Rayliu
 * @since 2022-11-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Visitor对象", description="")
public class Visitor implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "visitor_id", type = IdType.AUTO)
    private Integer visitorId;

    private Integer managerId;

    private Integer eventId;

    private Integer roleId;

    private String visitorName;

    private String visitorTel;

    @TableLogic
    private Integer deleted;


}
