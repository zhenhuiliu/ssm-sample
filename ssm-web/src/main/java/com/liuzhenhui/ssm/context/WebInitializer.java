package com.liuzhenhui.ssm.context;

import java.io.IOException;
import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import com.liuzhenhui.commons.utils.spring.ApplicationContextUtils;



/**
 * @author zhenhui.liu
 * 2017年5月11日 下午2:34:22
 */
public class WebInitializer implements WebApplicationInitializer {

	private static Logger logger = LoggerFactory.getLogger(WebInitializer.class);

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// 创建Spring上下文
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(SpringRootConfig.class);
		ConfigurableEnvironment environment = rootContext.getEnvironment();
		try {
			environment.getPropertySources().addFirst(new ResourcePropertySource("classpath:/environment.properties"));
		} catch (IOException e) {
			logger.error("", e);
		}
		// 管理Spring上下文的生命周期
		servletContext.addListener(new ContextLoaderListener(rootContext));
		// 将Spring上下文放入工具类
		ApplicationContextUtils.setApplicationContext(rootContext);

//		servletContext.setAttribute("staticFilesHost", environment.getProperty("static.files.host"));
		// 字符编码过滤器
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		encodingFilter.setForceEncoding(true);
		FilterRegistration.Dynamic characterEncodingFilter = servletContext.addFilter("characterEncodingFilter", encodingFilter);
		characterEncodingFilter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), false, "/*");

		// 创建SpringMVC上下文
		AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
		dispatcherContext.register(SpringMVCConfig.class);
		// 注册SpringMVC分发器
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");

	}
}
