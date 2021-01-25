package org.common.api.base;


import com.netu.lib.ApplicationService;
import com.netu.lib.Encryptor2;
import com.netu.lib.JsonModelObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang.StringUtils;
import org.common.api.web.ApiServicesApp;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

/**
 *
 * @author christoforosl
 */
public class ServicesRegister {
	
	private static final Logger logger = Logger.getLogger(ServicesRegister.class.getName());
	private static final String MODEL_BASE = "ModelBase";
	
	public Map<String, Class<? extends JsonModelObject>> scanAndRegisterClasses() {
		final Map<String, Class<? extends JsonModelObject>> MO_KEYS = new HashMap<>();
		final String modelPackage = ApplicationService.getNufProperty("modelPackageForRestAPI");
		if (StringUtils.isNotBlank(modelPackage)) {
			final Reflections reflections = new Reflections(modelPackage, new SubTypesScanner());
			final Set classes = reflections.getSubTypesOf(JsonModelObject.class);
			for (final Object oc : classes) {
				final Class cs2 = (Class) oc;
				if (!cs2.getSimpleName().endsWith(MODEL_BASE)) {
					final String hkey = cs2.getSimpleName().toLowerCase();
					final String testUrl = ApiServicesApp.BASE_JETTY_SERVER_URL + "api/services/model/" + cs2.getSimpleName().toLowerCase() + "/1";
					logger.log(Level.INFO, String.format("Register model API class %s with key %s\n   test url:%s", hkey, cs2.getName(), testUrl));
					MO_KEYS.put(hkey, cs2);
				}
			}
		}
		return MO_KEYS;

	}
	
}
