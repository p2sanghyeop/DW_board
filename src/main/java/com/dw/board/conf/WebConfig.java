package com.dw.board.conf;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.dw.board.interceptor.Interceptor;


@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	@Autowired
	private Interceptor interceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//우리가 만든 인터셉터를 스트링에 등록
		//excludePathPatterns: 해당url을 인터셉터대상에서 제외
		registry
		.addInterceptor(interceptor)
		.excludePathPatterns("/api/v1/logs","/api/v1/login","/login","/join","/resources/static/css/*","/resources/static/js/*","/resources/static/images/*","/error");
	}
}

