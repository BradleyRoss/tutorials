
package bradleyross.library.debugging;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
/**
 * @author Bradley Ross
 *
 */
public class Log4j2Test implements Runnable {
	public static Logger logger = LogManager.getLogger(Log4j2Test.class.getName());
	public void run() {
		logger.warn("This is the log4j 2.x test");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("This is the log4j 2.x API test");
		Log4j2Test instance = new Log4j2Test();
		instance.run();
	}

}
