package com.liuzhenhui.ssm.core.dubbo;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liuzhenhui.ssm.api.inner.dubbo.TestFacade;
import com.liuzhenhui.ssm.core.service.TestService;
@Service("testFacade")
public class TestFacadeImpl implements TestFacade{

	@Resource
	private TestService testService;
	
	@Override
	public String findHelloWord() {
		String result = "error";
		try {
			result= testService.findHelloWord();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
