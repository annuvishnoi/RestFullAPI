package com.fse.menurest.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyDeployDesc 
		extends AbstractAnnotationConfigDispatcherServletInitializer {

	//returns an array of classes : 
	//set of java classes for config of spring container
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	//return array of classes: 
	//set of java classes for config of  registered servlet ( private / helper config)
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] { MyDSConfig.class };
	}

	//return array of String:
	//set of urls to map with DS
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}

}
