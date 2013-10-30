package xap.oracle.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerTest {

	
	static Logger logger = LoggerFactory.getLogger(LoggerTest.class);
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 
		
		logger.debug("Hello there ");

	}

}
