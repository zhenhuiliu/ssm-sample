package com.liuzhenhui.ssm.core.dubbo;

import org.springframework.stereotype.Service;

import com.liuzhenhui.ssm.api.inner.dubbo.TestFacade;

@Service("testQueryFacade")
public class TestFacadeImpl implements TestFacade{

	
	@Override
	public String findHelloWord() {
		return null;
	}

}
