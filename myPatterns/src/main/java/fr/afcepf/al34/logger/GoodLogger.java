package fr.afcepf.al34.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GoodLogger {
	private static Logger logger = LoggerFactory.getLogger(GoodLogger.class);
	
	public void log(String message) {
		logger.info(message);
	}
}
