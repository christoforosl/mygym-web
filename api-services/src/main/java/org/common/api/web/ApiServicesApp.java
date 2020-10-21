package org.common.api.web;

import com.netu.lib.Encryptor2;
import com.netu.lib.db.ConnectionPool;
import com.netu.lib.db.IConnectionProvider;
import com.netu.lib.db.JDBCPooledConnProvider;
import com.netu.lib.text.DBLanguageStrings;
import com.netu.lib.text.Translator;
import com.netu.propertyutils.PropertiesByEnvironmentPrefix;
import org.common.rest.api.ApiServicesApplication;


import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.EnumSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.DispatcherType;
import org.apache.commons.lang.StringUtils;
import org.common.api.base.ServicesRegister;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;

public class ApiServicesApp {

	private static final String HEROKU_RELEASE_VERSION_KEY = "HEROKU_RELEASE_VERSION";

	public static final String HEROKU_RELEASE_VERSION = System.getenv(HEROKU_RELEASE_VERSION_KEY) == null ? 
			"1.0.1":System.getenv(HEROKU_RELEASE_VERSION_KEY) ;
	
	private static final Logger LOGGER = Logger.getLogger(ApiServicesApp.class.getName());
	private static final String KEY_ENVIRONMENT = "ENVIRONMENT";
	
	private static final PropertiesByEnvironmentPrefix props = (PropertiesByEnvironmentPrefix) new PropertiesByEnvironmentPrefix().setPropertiesResourceName("/generic-api-server.properties");
	
	public static void main(String[] args) throws Exception {
		
		LOGGER.info(String.format("SERVICES API STARTING, ENVIRONMENT: %s , HEROKU_RELEASE_VERSION:\"%s\"", 
				System.getenv(KEY_ENVIRONMENT), HEROKU_RELEASE_VERSION));
		
		String jettyPort = props.getProperty("jetty.port");
		int port =  StringUtils.isBlank( jettyPort )  ? 80 : Integer.valueOf(jettyPort);
		final Server jettyServer = getJettyServer(port);
		
		startServer(jettyServer);	
	}
	
	static Server getJettyServer (int port) throws Exception {
		
		final String current = new java.io.File(".").getCanonicalPath();
		LOGGER.log(Level.INFO, "Current dir:{0}", current);
		String currentDir = System.getProperty("user.dir");
		LOGGER.log(Level.INFO, "Current dir using System:{0}", currentDir);

		if (LOGGER.isLoggable(Level.FINE)) {
			
			ClassLoader cl = ClassLoader.getSystemClassLoader();
			URL[] urls = ((URLClassLoader) cl).getURLs();

			for (URL url : urls) {
				LOGGER.fine(url.getFile());
			}
		}
		final String resourceBase =  new File( props.getMandatoryProperty("resource.base") ).getAbsolutePath();
		
		final ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/");
		context.setResourceBase( resourceBase );
		context.addFilter(ServicesWebFilter.class, "/*", EnumSet.of(DispatcherType.INCLUDE, DispatcherType.REQUEST));
		context.addEventListener(new org.jboss.resteasy.plugins.server.servlet.ResteasyBootstrap());
		context.setWelcomeFiles(new String[]{ "index.html" }); 
		
		final String appsConnString = new Encryptor2().decrypt( props.getMandatoryProperty("jdbcurl"));
		final String appsConnDriver = props.getMandatoryProperty("jdbcurl.driver");
		
		JDBCPooledConnProvider.setSystemJdbcDriver(appsConnDriver); 
		IConnectionProvider ocpapps = new JDBCPooledConnProvider();
		ocpapps.setConnString(appsConnString);
		ConnectionPool.setConnectionProvider(ocpapps);
		
//		final int dbVersion = DBVersion.DB_VERSION;
//		DBUpgrader.createMySQLDBUpgrader().setJdbcUrlString(appsConnString).
//				setFilesPackagePath("/dbupdate").upgradeDatabase(dbVersion); 
//		
		
		Translator.setLangStrings(new DBLanguageStrings());
		final String servletContextName = context.getServletContext().getServletContextName();
		context.getServletContext().setAttribute(servletContextName + "INIT_OK", Boolean.TRUE);
				
		final ServletHolder sh = new ServletHolder(HttpServletDispatcher.class);
		sh.setName("Resteasy");
		sh.setInitOrder(0);
		sh.setInitParameter("javax.ws.rs.core.Application", ApiServicesApplication.class.getCanonicalName());
		context.addServlet(sh, "/api/*");	
		
		//see http://docs.jboss.org/resteasy/docs/3.0.19.Final/userguide/html/async_job_service.html#oneway
		context.setInitParameter("resteasy.async.job.service.enabled", "true");
		context.setInitParameter("resteasy.async.job.service.max.job.results", "100");
		context.setInitParameter("resteasy.async.job.service.max.wait", "300000");
		context.setInitParameter("resteasy.async.job.service.thread.pool.size","100");
		context.setInitParameter("resteasy.async.job.service.base.path","/asynch/jobs");
		context.setInitParameter("resteasy.servlet.mapping.prefix", "/api");
		context.setInitParameter("javax.ws.rs.core.Application", ApiServicesApplication.class.getCanonicalName());
		
		final Server jettyServer = new Server(port);
		
		// add special pathspec of "/home/" content mapped to the homePath
        ServletHolder holderHome = new ServletHolder("default", DefaultServlet.class);
        holderHome.setInitParameter("resourceBase",resourceBase);
        holderHome.setInitParameter("dirAllowed","true");
        holderHome.setInitParameter("pathInfoOnly","true");
        context.addServlet(holderHome,"/*");
		
		final HandlerList handlers = new HandlerList();
	    handlers.setHandlers(new Handler[] { context,new DefaultHandler()});
	    jettyServer.setHandler(handlers);
		
		BASE_JETTY_SERVER_URL = props.getMandatoryProperty("app.url");
		
		LOGGER.log(Level.INFO, String.format("\n\n******\n"
				+ "** JETTY Initialized and started succesfully.\n"
				+ "** Resource Base: %s.\n"
				+ "** Database Connection: %s.\n"
				+ "** Test Static Page: %s/index.html \n"
				+ "** Test API: %s/api/services/model/XXXX/361\n********\n",resourceBase, appsConnString, BASE_JETTY_SERVER_URL, BASE_JETTY_SERVER_URL, BASE_JETTY_SERVER_URL));
		
		new ServicesRegister().scanAndRegisterClasses();
		
		context.setInitParameter("baseurl", BASE_JETTY_SERVER_URL);
		
		return jettyServer;
		
	}
	
	public static String BASE_JETTY_SERVER_URL = null;
	
	static void startServer(final Server jettyServer) {
		try {
			
			jettyServer.start();
			jettyServer.join();
			
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error in jetty processing", e);
		} finally {
			jettyServer.destroy();
		}
	}
	
	
}
