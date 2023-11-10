package com.dormManage.system.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
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
@ApiModel(value="Student对象", description="")
public class Student implements Serializable {

    @TableId(value = "stu_id",type = IdType.AUTO)
    private Integer stuId;

    private Integer characterId;

    private Integer hobbyId;

    private Integer timeId;

    private Integer healthId;

    private Integer acId;

    private Integer consumptionId;

    private Integer roomId;

    private Integer roleId;

    private String stuName;

    private String stuGrade;

    private String stuTel;

    private String stuCollege;

    private String stuMajor;

    private String stuClass;

    @TableLogic
    private Integer deleted;

    private Integer userId;
}
