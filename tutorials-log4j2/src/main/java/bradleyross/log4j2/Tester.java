
package bradleyross.log4j2;
import bradleyross.library.debugging.Log4j1Test;
import bradleyross.library.debugging.Log4j2Test;
import bradleyross.library.debugging.Slf4jTest;
import bradleyross.library.debugging.CommonsTest;
/**
 * This class runs the demonstrations for processing
 * exceptions using the log4j 2.x environment.
 * 
 * <p>The dependencies specified in the pom allow use of 
 *    Apache Commons Logging,
 *    Apache log4j, Apache log4j 2, and slf4j logging API's.</p>
 * 
 * @author Bradley Ross
 *
 */
public class Tester {

	/**
	 * Tests functionality of log4j 1.x, log4j 2, and slf4j logging API's with
	 * log4j 2 implementation classes.
	 * 
	 * @param args not used in this case
	 */
	public static void main(String[] args) {
		System.out.println("Logging test using log4j 2.x class files");
		String[] temp = {"a", "b"};
		Log4j1Test.main(temp);
		Log4j2Test.main(temp);
		Slf4jTest.main(temp);
		CommonsTest.main(temp);
	}
}
