package com.liuzhenhui.ssm.context;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @Description: dubbo消费者配置
 * @see: DubboClientConfig 此处填写需要参考的类
 * @version 2016年8月24日 下午6:20:49
 * @author qinji.xu
 */
@Configuration
@ImportResource("classpath:dubbo-client.xml")
public class DubboClientConfig {}
