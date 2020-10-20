package org.common.rest.api;

import com.netu.lib.rest.SearchResults;
import org.common.api.web.ApiServicesApp;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.commons.lang.StringUtils;

@Path("entry-point")
public class EntryPoint {

    @GET
    @Path("server-status-txt")
    @Produces(MediaType.TEXT_PLAIN)
    public String ServerAliveTestText() {
        return "1";
    }
	
	/**
	 * listen to http://localhost:9001/services/entry-point/server-status
	 * @return 
	 */
	@GET
    @Path("server-status")
    @Produces(MediaType.APPLICATION_JSON)
    public SearchResults ServerAliveTest() {
		SearchResults ret = new SearchResults();
		final Map<String, String> hres = new HashMap<>();
		hres.put("status", "alive");
		ret.setResults(hres);
        return ret;
    }
	/**
	 * listen to http://localhost:9001/services/entry-point/appVersion
	 * @return 
	 */
	@GET
    @Path("app-version")
    @Produces(MediaType.TEXT_PLAIN)
    public String appVersion() {
		
        return StringUtils.defaultString(ApiServicesApp.HEROKU_RELEASE_VERSION, "0.999-beta");
		
    }
}