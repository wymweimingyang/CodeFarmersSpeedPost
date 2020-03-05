package com.example.service.impl;

import com.example.entity.Worker;
import com.example.mapper.WorkerMapper;
import com.example.service.IWorkerService;
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
public class WorkerServiceImpl extends ServiceImpl<WorkerMapper, Worker> implements IWorkerService {

}
