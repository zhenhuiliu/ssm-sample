/**
 * 
 */
package com.liuzhenhui.ssm.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhenhui.liu
 * 2017年5月12日 下午2:04:51
 */
@Controller
@RequestMapping("/test")
public class TestController {

	@RequestMapping("/hello")
	@ResponseBody
	public String helloWorld() {
		return "hello world";
	}
}
