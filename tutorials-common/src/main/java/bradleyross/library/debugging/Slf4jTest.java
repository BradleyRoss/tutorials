package bradleyross.library.debugging;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Tests ability to work with slf4j API.
 * @author Bradley Ross
 *
 */
public class Slf4jTest implements Runnable {
	/**
	 * slf4j logger class.
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
