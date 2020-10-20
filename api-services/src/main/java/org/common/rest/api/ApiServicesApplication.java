package org.common.rest.api;

import org.common.api.base.CommonResourceHandler;
import org.common.api.base.PredefinedServicesExecutor;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;
import javax.ws.rs.core.Application;

/**
 * org.dtph.web.central.service.jaxrs.BaseApplication
 * @author christoforosl
 */
public class ApiServicesApplication extends Application {

	private static final Logger LOGGER = Logger.getLogger(ApiServicesApplication.class.getName());

	private static final Set<Class<?>> CLASSES;

	static {
		
		HashSet<Class<?>> tmp = new HashSet<>();
		tmp.add(EntryPoint.class);
		tmp.add(CommonResourceHandler.class);
		tmp.add(SeedService.class);        
		
		tmp.add(PredefinedServicesExecutor.class);
		
		CLASSES = Collections.unmodifiableSet(tmp);
	}

	@Override
	public Set<Class<?>> getClasses() {
		//return Collections.emptySet();
		return  CLASSES;
	}

}
