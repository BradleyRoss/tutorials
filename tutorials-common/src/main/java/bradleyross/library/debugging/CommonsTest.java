
package bradleyross.library.debugging;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * Test for usability commons-logging API.
 * 
 * <p>See https://cyntech.wordpress.com/2009/01/09/how-to-use-commons-logging/ </p>
 * @author Bradley Ross
 * @see org.apache.commons.logging.Log
 * @see org.apache.commons.logging.LogFactory
 *
 */
public class CommonsTest implements Runnable {
	Log logger = LogFactory.getLog(CommonsTest.class);
	/**
	 * Carries out actual test.
	 */
	public void run() {
		logger.info("Using commons-logging API interface");
		System.out.println("This is the commons-logging API interface");
	}
	/**
	 * Test driver.
	 * @param args not used in this class
	 */
	public static void main(String[] args) {
		CommonsTest instance = new CommonsTest();
		instance.run();
	}
}
