package org.common.api.base;

import com.netu.lib.NetuUtils;
import com.netu.lib.rest.EnumRestResultStatus;
import com.netu.lib.rest.SearchResults;
import org.common.api.web.ApiServicesApp;
import java.util.Properties;
import java.util.logging.Level;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.commons.lang.StringUtils;


/**
 *
 * @author christoforosl
 */
@Path("/services")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON)
public class PredefinedServicesExecutor {

	private static final Properties SERVICES_DEFINITIONS;
	
	static {

		SERVICES_DEFINITIONS = NetuUtils.getProperties("serviceDefinition.properties");

	}
	public static Properties getPredefinedServicesProperties() {
		return SERVICES_DEFINITIONS;
	}

	
	
	@GET
    @Path(value = "web/doService/{serviceKey}{path:.*}")
	public SearchResults doWebObjectOrientedActionApi(@PathParam(value = "serviceKey") final String serviceKey, @PathParam(value = "path") final String path) throws Exception {
		return runActionApi(serviceKey, path);
	}
	
	public SearchResults runActionApi(final String serviceKey, final String path) {
		
		final SearchResults ret = new SearchResults();
		final String service = StringUtils.isNotBlank( getPredefinedServicesProperties().getProperty(serviceKey)) ?
								 getPredefinedServicesProperties().getProperty(serviceKey) : 
								 getPredefinedServicesProperties().getProperty("defaultPackage")+"."+serviceKey;
		try {
			
			final String xpath = (path.startsWith("/")) ? path.substring(1) : path;
			final String[] params = (String[]) xpath.split("/");
			final IActionExecutor exec = (IActionExecutor) Class.forName(service).newInstance();
			final SearchResults serviceResults = exec.executeAction( params);
			ret.setNumResults(serviceResults.getNumResults());
			ret.setResults(serviceResults.getResults());
			ret.setStatus(EnumRestResultStatus.SUCCESS);
			ret.setDebugInfo(serviceResults.getDebugInfo() == null ? ApiServicesApp.HEROKU_RELEASE_VERSION :serviceResults.getDebugInfo() );
			
		} catch (Exception e) {
			final String msg = String.format("Error executing action service \"%s\" with key \"%s\":%s", 
					service, serviceKey, e.getClass().getName().equals("java.lang.ClassNotFoundException") ? "ClassNotFoundException:" + e.getMessage() : e.getMessage());
			BaseResource.LOGGER.log(Level.SEVERE, msg, e);
			ret.setStatus(EnumRestResultStatus.ERROR);
			ret.setError(msg);
		
		} finally {
		
		}
		
		return ret;
	}
	
}
