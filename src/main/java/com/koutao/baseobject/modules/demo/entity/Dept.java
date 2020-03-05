package com.koutao.baseobject.modules.demo.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author koutao
 * @since 2018-11-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Dept extends Model<Dept> {

    private static final long serialVersionUID = 1L;

    private String deptno;
    private String dname;
    private String dbSource;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
