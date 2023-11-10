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
@ApiModel(value="Sanitation对象", description="")
public class Sanitation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "sanitation_id", type = IdType.AUTO)
    private Integer sanitationId;

    private Integer roomId;

    private String sanitationLevel;

    @TableLogic
    private Integer deleted;


}
