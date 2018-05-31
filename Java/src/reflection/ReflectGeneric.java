package reflection;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class ReflectGeneric {
	public static void main(String[] args) {
		overCheckOfGeneric();
	}
	
	/**
	 * ignore generic check
	 */
	public static void overCheckOfGeneric(){
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("a");
		
		Class<?> c = arrayList.getClass();
		try {
			Method method = c.getMethod("add",Object.class);
			
			method.invoke(arrayList , 100);
			method.invoke(arrayList, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (Object obj : arrayList) {
			System.out.println(obj.toString());
		}
	}

}
