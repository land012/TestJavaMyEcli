package com.umbrella.spring.boot;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
/**
 * �� Tomcat ����ʱ������ᱻִ�У���ʼ��Spring
 * @author asdf
 *
 */
public class WebXml extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

}
