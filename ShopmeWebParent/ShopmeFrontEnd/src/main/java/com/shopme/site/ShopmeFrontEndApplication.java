package com.shopme.site;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import ch.qos.logback.core.joran.action.AppenderAction;

@SpringBootApplication
public class ShopmeFrontEndApplication {

	
//	  public void addResourceHandlers(ResourceHandlerRegistry registry) {
//	    registry.addResourceHandler("/css/**")
//	            .addResourceLocations("classpath:/static/css/");
//	    registry.addResourceHandler("/js/**")
//	            .addResourceLocations("classpath:/static/js/");
//	  }
//	
	 
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(AppenderAction.class);
	    }
	
	public static void main(String[] args) {
		SpringApplication.run(ShopmeFrontEndApplication.class, args);
	}

}
