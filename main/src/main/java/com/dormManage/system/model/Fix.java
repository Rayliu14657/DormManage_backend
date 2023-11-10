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
@ApiModel(value="Fix对象", description="")
public class Fix implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "fix_id", type = IdType.AUTO)
    private Integer fixId;

    private Integer roomId;

    private Integer managerId;

    private String fixDesc;

    private String fixState;

    private String fixTime;

    @TableLogic
    private Integer deleted;


}
