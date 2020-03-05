package com.koutao.baseobject.modules.demo.service.impl;

import com.koutao.baseobject.modules.demo.entity.Dept;
import com.koutao.baseobject.modules.demo.dao.DeptMapper;
import com.koutao.baseobject.modules.demo.service.DeptService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author koutao
 * @since 2018-11-25
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {

}
