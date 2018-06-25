package collection.map;

/**
 * Hello world!
 *
 */
public class App 
{
    @SuppressWarnings("null")
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