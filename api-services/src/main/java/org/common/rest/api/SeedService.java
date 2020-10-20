
package org.common.rest.api;

import com.netu.lib.db.HashMapRecordset;
import com.netu.lib.rest.EnumRestResultStatus;
import com.netu.lib.rest.SearchResults;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;

/**
 *
 * @author artemis
 */
@Path("/services")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON)
public class SeedService {
	
	private static final Logger logger = Logger.getLogger(SeedService.class.getName());
	private static final Properties seeds;
	private static final String SEEDS_PROPERTIES_FILE = "seeds.properties";
	
	static Properties getAllSeeds() {
		return seeds;
	}
	
	static {
		seeds = new Properties();
		try (InputStream istrm = SeedService.class.getClassLoader().getResourceAsStream(SEEDS_PROPERTIES_FILE)) {
			seeds.load(istrm);
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}
	
	
	 
	@GET
	@Path(value = "seeds/{seedsRequested}")
	public SearchResults getSeeds (@PathParam("seedsRequested") String seedsRequested) throws ServletException, Exception {

		String seedsKey = null;
		final SearchResults ret = new SearchResults();
		//Connection conn = null;
		HashMap<String, Object> lstRecords = new HashMap<>();

		final String[] seedsArr = StringUtils.split(seedsRequested, COMMA);

		try { 
			//conn = ConnectionPool.getConn();

			for (final String seedsKeyLoop : seedsArr) {
				seedsKey = seedsKeyLoop;
				final String sql = seeds.getProperty(seedsKey);
				Validate.isTrue(StringUtils.isNotBlank(sql), MISSING_SQL_FOR_KEY + seedsKey);
				final HashMapRecordset hs = new HashMapRecordset(sql);
				hs.setCamelCase(true);
 				lstRecords.put(seedsKey, hs.getMap());
 			
			}
			
			ret.setResults(lstRecords);
			ret.setStatus(EnumRestResultStatus.SUCCESS);
			ret.setNumResults(lstRecords.size());
			
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error thrown during getSeedsFromObject execution for seeds key:{0}", seedsKey);
			ret.setStatus(EnumRestResultStatus.ERROR);
			ret.setError(e instanceof NullPointerException ? "NullPointerException" : e.getMessage());

		} finally {
			//DBUtils.closeQuietly(conn);
		}
		return ret;
	}
	private static final char COMMA = ',';
	private static final String MISSING_SQL_FOR_KEY = "Missing sql for key:";
	
}
