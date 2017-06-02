package com.liuzhenhui.ssm.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.liuzhenhui.ssm.core.service.TestService;
import com.liuzhenhui.ssm.dao.dao.UserMapper;

@Service("testService")
public class TestServiceImpl implements TestService{

	@Resource
	private UserMapper userMapper;
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public String findHelloWord() {
		return userMapper.selectByPrimaryKey(1L).getUserName();
	}

}
