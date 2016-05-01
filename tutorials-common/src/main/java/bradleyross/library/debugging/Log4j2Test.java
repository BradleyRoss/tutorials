
package bradleyross.library.debugging;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
/**
 * Tests use of the log4j 2.x API with the system.
 * @author Bradley Ross
 *
 */
public class Log4j2Test implements Runnable {
	public static Logger logger = LogManager.getLogger(Log4j2Test.class.getName());
	/**
	 * Method actually carrying out the test.
	 */
	public void run() {
		logger.warn("This is the log4j 2.x test");
	}
	/**
	 * Test driver.
	 * @param args not used in this class
	 */
	public static void main(String[] args) {
		System.out.println("This is the log4j 2.x API test");
		Log4j2Test instance = new Log4j2Test();
		instance.run();
	}

}
