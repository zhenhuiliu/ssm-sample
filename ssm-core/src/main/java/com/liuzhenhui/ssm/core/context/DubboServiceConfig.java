package com.liuzhenhui.ssm.core.context;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @Description: dubbo提供者配置
 * @see: DubboServiceConfig 此处填写需要参考的类
 * @version 2016年8月24日 下午6:21:50
 * @author qinji.xu
 */
@Configuration
@ImportResource("classpath:dubbo-service.xml")
public class DubboServiceConfig {

}
