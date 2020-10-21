package org.common.api.web;

import com.netu.lib.ApplicationService;
import com.netu.lib.Model.GenericUser;
import com.netu.lib.cache.LookupManager;
import com.netu.lib.db.ConnectionPool;
import com.netu.lib.text.Translator;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author christoforosl
 */
public class ServicesWebFilter implements Filter {
	
	private static final Logger LOGGER = Logger.getLogger(ServicesWebFilter.class.getName());

	// The filter configuration object we are associated with.  If
	// this value is null, this filter instance is not currently
	// configured. 
	private final FilterConfig filterConfig = null;

	/**
	 *
	 * @param request The servlet request we are processing
	 * @param response The servlet response we are creating
	 * @param chain The filter chain we are processing
	 *
	 * @exception IOException if an input/output error occurs
	 * @exception ServletException if a servlet error occurs
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		final HttpServletResponse res = (HttpServletResponse) response;
		final HttpServletRequest req = (HttpServletRequest) request;
		final String requestURI = req.getRequestURI();

		ConnectionPool.resetDefaultConnectionPoolName();
		if (request.getParameterMap().containsKey("refreshcaches")) {
			LOGGER.info("Received command \"refreshcaches\" on the url, will refresh caches");
			LookupManager.current().resetAll();
		} 
		
		this.checkInitilizeStatus(req, res);

		if (requestURI.startsWith("/api")) {
			
			res.addHeader("Access-Control-Allow-Origin", "*");
			res.addHeader("Access-Control-Allow-Credentials", "true");
			res.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, HEAD");
			res.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, X-Requested-With,Cache-Control");
			res.addHeader("P3P", "CP=\"CAO PSA OUR\""); // Makes IE to support cookies
			
			if (LOGGER.isLoggable(Level.INFO)) {
				LOGGER.fine(MessageFormat.format("Filtering URI:{0}", requestURI));
			}
			
			ConnectionPool.resetDefaultConnectionPoolName();
			if (request.getParameterMap().containsKey("refreshcaches")) {
				LOGGER.info("Received command \"refreshcaches\" on the url, will refresh caches");
				LookupManager.current().resetAll();
			} 
			
			try {

				Translator.setLocale( Locale.ENGLISH );
				this.setupApplicationService(req);
				chain.doFilter(request, response);

			} catch (Throwable t) {
				LOGGER.log(Level.SEVERE, "Error in filter", t);
				throw new ServletException(t);

			} finally {
				if (LOGGER.isLoggable(Level.FINE)) {
					LOGGER.log(Level.INFO, MessageFormat.format("ApplicationService.released: {0,number,#}, thread: {1,number,#}",
							ApplicationService.Current().hashCode(), Thread.currentThread().hashCode()));
				}
				ApplicationService.release();
			}

		} else {
			chain.doFilter(request, response);
		}

	}

	public void checkInitilizeStatus(final HttpServletRequest req, final HttpServletResponse res) throws IOException, ServletException {

		final String servletContextName = req.getServletContext().getServletContextName();
		final Object initOk = req.getServletContext().getAttribute(servletContextName + "INIT_OK");

		if (!Boolean.TRUE.equals(initOk)) {
			throw new ServletException(servletContextName + " Failed initialization with error: "
					+ req.getServletContext().getAttribute(servletContextName + "_Error"));

		}

	}

	private void setupApplicationService(final HttpServletRequest req) throws Exception {

		final String tokenUsername = getTokenUsername(req);
		LOGGER.log(Level.FINE, MessageFormat.format("Got Username from token >>{0}", tokenUsername));
		
		if (ApplicationService.Current() == null) {
			ApplicationService.newCurrent();
			if (LOGGER.isLoggable(Level.FINE)) {
				LOGGER.log(Level.FINE, MessageFormat.format("ApplicationService init:{0,number,#}, thread id: {1,number,#}",
						ApplicationService.Current().hashCode(), Thread.currentThread().hashCode()));
			}
		}

		ApplicationService.Current().setConnection(ConnectionPool.getConn());
		ApplicationService.Current().setPrincipal(new GenericUser(tokenUsername));

	}

	
	private String getTokenUsername(final HttpServletRequest req) throws Exception {
		
		return "eugenia";
		
	}
	
	
	@Override
	public void init(FilterConfig fc) throws ServletException {
	
	}
		
	@Override
	public void destroy() {

	}

}
