package com.pc.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pc.entry.TestData;
import com.pc.mapper.TestMapper;
import com.pc.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, TestData> implements TestService {

}
