/**
 * 
 */
package com.liuzhenhui.ssm.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liuzhenhui.ssm.api.inner.dubbo.TestFacade;

/**
 * @author zhenhui.liu
 * 2017年5月12日 下午2:04:51
 */
@Controller
@RequestMapping("/test")
public class TestController {

	@Resource
	private TestFacade testFacade;
	
	@RequestMapping("/hello")
	@ResponseBody
	public String helloWorld() {
		return testFacade.findHelloWord();
	}
}
