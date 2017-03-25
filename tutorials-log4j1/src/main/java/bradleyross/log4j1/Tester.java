package bradleyross.log4j1;
import bradleyross.library.debugging.Log4j1Test;
// import bradleyross.library.debugging.Log4j2Test;
import bradleyross.library.debugging.Slf4jTest;
import bradleyross.library.debugging.CommonsTest;
/**
 * This class demonstrates the behavior of the log4j 1.x
 * implementation classes in dealing with the log4j 1.x
 * and slf4j API sets.
 * @author Bradley Ross
 *
 */
public class Tester {
	/**
	 * Test driver.
	 * @param args not used in this class
	 */
	public static void main(String[] args) {
		System.out.println("Logging test using log4j 1.x class files");
		String[] temp = {"a", "b"};
		Log4j1Test.main(temp);
		// Log4j2Test.main(temp);
		Slf4jTest.main(temp);
		CommonsTest.main(temp);
	}
}
