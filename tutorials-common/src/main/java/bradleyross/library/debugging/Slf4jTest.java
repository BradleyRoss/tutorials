package bradleyross.library.debugging;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Tests ability to work with slf4j API.
 * @author Bradley Ross
 * 
 * <p>I am having a problem in that the links for Logger and 
 *    LoggerFactory do not link to the external Javadocs.</p>
 * <ul>
 * <li>see <a href="http://www.slf4j.org/apidocs/org/slf4j/Logger.html" target="_blank">org.slf4j.Logger</a></li>
 * <li>see <a href="http://www.slf4j.org/apidocs/org/slf4j/LoggerFactory.html" target="_blank">org.slf4j.LoggerFactory</a></li>
 * </ul>
 * @see org.slf4j.Logger
 * @see org.slf4j.LoggerFactory
 */
// FIXME find out why Logger and LoggerFactory can't be clicked on
public class Slf4jTest implements Runnable {
	/**
	 * slf4j logger class.
	 * 
	 */
	protected static Logger logger = LoggerFactory.getLogger(Slf4jTest.class.getName());
	/**
	 * Runs the actual test.
	 */
	public void run() {
		logger.info("This is the slf4j API example");
		System.out.println("This is the slf4j API example");		
	}
	/**
	 * Test driver
	 * @param args not used in this program
	 */
	public static void main(String[] args) {

		Slf4jTest instance = new Slf4jTest();
		instance.run();

	}

}
