package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2020-03-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("rec_apply")
public class Apply implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "applynum", type = IdType.AUTO)
    private Long applynum;

    private Long wid;

    private Long jid;

    @TableField("applyDate")
    private LocalDate applyDate;

    private Integer state;


}
