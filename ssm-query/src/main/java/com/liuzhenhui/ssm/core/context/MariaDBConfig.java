package com.liuzhenhui.ssm.core.context;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


/**
 * @Description: MariaDB数据源配置
 * @see: MariaDBConfig 此处填写需要参考的类
 * @version 2016年8月24日 下午6:22:10
 * @author qinji.xu
 */
@Configuration
@PropertySource("classpath:/system.properties")
public class MariaDBConfig {

	private static final Logger logger = LoggerFactory.getLogger(MariaDBConfig.class);

	@Value("${com.lefu.alliance.core.ds.name}")
	private String dsName;

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		long l = System.currentTimeMillis();
		logger.info("dsName = {} , {}", dsName, l);
		DataSource ds = new ComboPooledDataSource();
		return ds;
	}

}
