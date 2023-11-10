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
@ApiModel(value="Suggestion对象", description="")
public class Suggestion implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "suggestion_id", type = IdType.AUTO)
    private Integer suggestionId;

    private Integer stuId;

    private Integer roomId;

    private String suggestion;

    @TableLogic
    private Integer deleted;


}
