package cn.tedu.store;

import javax.servlet.MultipartConfigElement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

@SpringBootApplication
@Configuration
@MapperScan("cn.tedu.store.mapper")
public class StoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
	}

	/**
	 * 获取MultipartConfigElement
	 * 
	 * 添加了
	 * 
	 * <pre>
	 * &#64;Bean
	 * </pre>
	 * 
	 * 注解的方法，会被Spring框架调用，并管理返回的对象
	 * 
	 * @return MultipartConfigElement类型的对象 是上传文件的配置类型的对象
	 */
	@Bean
	public MultipartConfigElement aaa() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		// ===========关于文件上传的全局配置(整个项目的配置)========
		// 头像：500KB
		// 买家秀照片：1MB
		// 买家秀视频：5MB
		// ============全局设置：此项目中任何上传功能都不能超过设置值===================
		// 上传的文件的最大大小
		factory.setMaxFileSize(DataSize.ofMegabytes(2));
		// 请求的数据量的最大大小
		factory.setMaxRequestSize(DataSize.ofMegabytes(2));

		return factory.createMultipartConfig();
	}

}
