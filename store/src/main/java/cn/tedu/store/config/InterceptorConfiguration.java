package cn.tedu.store.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import cn.tedu.store.interceptor.LoginInterceptor;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：下午4:55:41
 * @description 描述：拦截器的配置类
 */

@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {
	/**
	 * 添加拦截器的方法
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		HandlerInterceptor interceptor = new LoginInterceptor();
		List<String> patterns = new ArrayList<>();
		patterns.add("/bootstrap3/**");
		patterns.add("/css/**");
		patterns.add("/js/**");
		patterns.add("/images/**");
		patterns.add("/districts/**");
		patterns.add("/products/**");
		patterns.add("/web/register.html");
		patterns.add("/web/login.html");
		patterns.add("/web/index.html");
		patterns.add("/web/product.html");
		patterns.add("/web/jquery-getUrlParam.js");
		patterns.add("/users/reg");
		patterns.add("/users/login");
		// addPathPatterns:添加黑名单 excludePathPatterns：添加白名单 必须先黑后白
		registry.addInterceptor(interceptor).addPathPatterns("/**").excludePathPatterns(patterns);
	}
}
