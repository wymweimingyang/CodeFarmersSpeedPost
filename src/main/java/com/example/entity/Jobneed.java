package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wanghao
 * @since 2020-03-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("rec_jobneed")
public class Jobneed implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long jid;

    private Long cid;

    @TableField("jobInfo")
    private String jobInfo;

    @TableField("contactWay")
    private String contactWay;

    @TableField("companyInfo")
    private String companyInfo;


}
