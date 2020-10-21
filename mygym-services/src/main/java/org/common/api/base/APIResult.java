package org.common.api.base;


import com.netu.lib.rest.EnumRestResultStatus;
import java.net.InetAddress;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;


/**
 * Base class for REST API results.
 * @author christoforosl
 */
public class APIResult {
	
	protected static final String HOSTNAME ;
	protected String error;
	protected Object results;
	protected Date timestamp =  new Date();
	protected EnumRestResultStatus status;
	
	
	
	private static final Logger LOGGER = Logger.getLogger(APIResult.class.getName());
	
	static {
		String tmp = StringUtils.EMPTY ;
		try {
			
			tmp = InetAddress.getLocalHost().getHostName();
		
		} catch (Exception ex) {
			LOGGER.log(Level.SEVERE, "Exception getting hostname", ex);
		}
		
		HOSTNAME = tmp;
		
	}
	
	public static APIResult SUCCESS( final Object results) {
		APIResult ret = new APIResult(); 
		ret.status = EnumRestResultStatus.SUCCESS;
		ret.error = null;
		ret.results = results;
		
		return ret;
	}
	
	public static APIResult ERROR( final String errorMessage) {
		APIResult ret = new APIResult(); 
		ret.status = EnumRestResultStatus.ERROR;
		ret.error = errorMessage;
		ret.results = null;
		return ret;
	}
	
	public static APIResult ERROR( final Throwable thr) {
		LOGGER.log(Level.SEVERE, ExceptionUtils.getMessage(thr) ,ExceptionUtils.getRootCause(thr));
		APIResult ret = new APIResult(); 
		ret.status = EnumRestResultStatus.ERROR;
		ret.error = thr.getMessage();
		ret.results = null;
		return ret;
	}
	
	private APIResult() {
		
	}
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Object getResults() {
		return results;
	}

	public void setResults(Object results) {
		this.results = results;
	}

	public EnumRestResultStatus getStatus() {
		return status;
	}

	public void setStatus(EnumRestResultStatus status) {
		this.status = status;
	}

	public Date getTimestamp() {
		return timestamp;
	}
	
	public String getHostname() {
		return HOSTNAME;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
}
