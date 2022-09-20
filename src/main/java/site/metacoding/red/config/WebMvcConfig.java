package site.metacoding.red.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import site.metacoding.red.handler.HelloInterceptor;
import site.metacoding.red.handler.LoginInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor())
		.addPathPatterns("/s/**");//s뒤의 모든주소, /s/* 은 /s/boards, /s/users 처럼 한단계까지만 이동 가능 -> 매칭이 안됨
		registry.addInterceptor(new HelloInterceptor())
	      .addPathPatterns("/hello/**");

		//.addPathPatterns("/admin")
		//.excludePathPatterns("/s/boards/**"); //특정한 주소 제외, 여기서는 /s/boards로 시작하는 주소들을 제외
	}
}
