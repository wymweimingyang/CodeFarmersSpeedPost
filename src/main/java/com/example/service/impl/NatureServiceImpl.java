package com.example.service.impl;

import com.example.entity.Nature;
import com.example.mapper.NatureMapper;
import com.example.service.INatureService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wanghao
 * @since 2020-03-05
 */
@Service
public class NatureServiceImpl extends ServiceImpl<NatureMapper, Nature> implements INatureService {

}
