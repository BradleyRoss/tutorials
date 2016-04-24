/**
 * 
 */
package bradleyross.library.debugging;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @author Bradley Ross
 *
 */
public class Slf4jTest implements Runnable {
	protected static Logger logger = LoggerFactory.getLogger(Slf4jTest.class.getName());
	public void run() {
		logger.info("This is the slf4j API example");
		System.out.println("This is the slf4j API example");		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Slf4jTest instance = new Slf4jTest();
		instance.run();

	}

}
