package collection.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try {
    		 System.out.println("a".equals(null));
    		 
    		 String aString = null;
    		 System.out.println(aString.equals("a"));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}