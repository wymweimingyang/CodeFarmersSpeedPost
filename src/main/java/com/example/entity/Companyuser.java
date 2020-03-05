package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("rec_companyuser")
public class Companyuser implements Serializable {

    private static final long serialVersionUID = 1L;

    private String cuser;

    private String cpassword;

    private Long cid;


}
