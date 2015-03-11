package locator;

import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ServicesLocator {
	private Context context;
	private Map<String, Object> cache;

	private static ServicesLocator instance;

	private ServicesLocator() {
		cache = new HashMap<>();
		try {
			context = new InitialContext();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public static ServicesLocator getInstance() {
		if (instance == null) {
			instance = new ServicesLocator();
		}
		return instance;
	}

	public synchronized Object getProxy(String jndiName) {
		Object proxy = null;
		proxy = cache.get(jndiName);
		if (proxy == null) {
			try {
				proxy = context.lookup(jndiName);
			} catch (NamingException e) {
				e.printStackTrace();
			}
			cache.put(jndiName, proxy);
		}
		return proxy;

	}

}
