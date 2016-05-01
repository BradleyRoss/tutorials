package bradleyross.library.debugging;
import org.apache.log4j.Logger;
/**
 * Tests the ability of the system to use the log4j 1.x API.
 * 
 * @author Bradley Ross
 *
 */
public class Log4j1Test implements Runnable {
	protected Logger logger = Logger.getLogger(Log4j1Test.class);
	/**
	 * The run method actually carries out the test.
	 */
	public void run() {
		logger.info("Test");
		logger.error("This is the log4j 1.x API test");
	}
	/**
	 * Test driver.
	 * @param args - not used in this method
	 */
	public static void main(String[] args) {
		System.out.println("This is the log4j 1.x API test");
		Log4j1Test instance = new Log4j1Test();
		instance.run();
	}
}
