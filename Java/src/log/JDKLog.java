package log;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDKLog {

	public static void main(String[] args) {
		System.out.println(1);
		logger.setLevel(Level.FINE);
		logger.info("info");
	}

	public static Logger logger = Logger.getLogger(JDKLog.class.toString());
	
	static{
		Handler consoleHandler = new ConsoleHandler();//console
		consoleHandler.setLevel(Level.FINE);
		logger.addHandler(consoleHandler);
	}
}
