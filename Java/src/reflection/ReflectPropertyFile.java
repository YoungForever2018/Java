package reflection;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
/**
 * 
 * load the class dynamically using reflection
 *
 */
public class ReflectPropertyFile {

	private static Map<Object,Object> map = new HashMap<Object, Object>();
	
	/**
	 * load properties
	 */
	static{
		try {
			String path = ReflectPropertyFile.class.getResource("/reflect/property.txt").getPath();
			FileReader fReader = new FileReader(path);
			//FileInputStream fis = new FileInputStream(path);
			Properties properties = new Properties();
			properties.load(fReader);
			Set<Entry<Object, Object>> entrySet = properties.entrySet();

			Iterator<Entry<Object, Object>> iterator = entrySet.iterator();
			while (iterator.hasNext()) {
				Entry<Object, Object> entry = iterator.next();
				map.put(entry.getKey(), entry.getValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String className = map.get("className").toString();
		String methodName = map.get("methodName").toString();
		
		Class<?> c = Reflect.getClass(className);
		
		try {
			Method method = c.getMethod(methodName, String.class,String.class);
			Object obj = c.getConstructor().newInstance();
			method.invoke(obj, "hello","hi");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
