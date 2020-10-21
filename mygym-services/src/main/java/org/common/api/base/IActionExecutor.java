package org.common.api.base;

import com.netu.lib.rest.SearchResults;

/**
 *
 * @author christoforosl
 */
public interface IActionExecutor {
	
	public SearchResults executeAction( String[] params) throws Exception;
	
}
