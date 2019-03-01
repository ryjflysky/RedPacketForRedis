package org.concurrent.red.config;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//@WebServlet(name = "dispatcherServlet", urlPatterns = "*.do", loadOnStartup = 1)
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"*.do"};
	}
	
	@Override
	protected void customizeRegistration(Dynamic registration) {
		String path = "F://java";
		Long singleMax = (long) (5 * Math.pow(2, 20));
		Long totalMax = (long) (10 * Math.pow(2, 20));
		registration.setMultipartConfig(new MultipartConfigElement(path, singleMax, totalMax, 0));
	}
}
