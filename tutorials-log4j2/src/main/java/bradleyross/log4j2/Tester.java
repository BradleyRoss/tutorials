
package bradleyross.log4j2;
import bradleyross.library.debugging.Log4j1Test;
import bradleyross.library.debugging.Log4j2Test;
import bradleyross.library.debugging.Slf4jTest;
/**
 * This class runs the demonstrations for processing
 * exceptions using the log4j 2.x environment.
 * 
 * <p>The dependencies specified in the pom allow use of 
 *    log4j, log4j2, and slf4j logging API's.</p>
 * 
 * @author Bradley Ross
 *
 */
public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Logging test using log4j 2.x class files");
		String[] temp = {"a", "b"};
		Log4j1Test.main(temp);
		Log4j2Test.main(temp);
		Slf4jTest.main(temp);

	}

}
