package bradleyross.experiments;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Random;
/**
 * Program for demonstration of password generation by randomly selecting words.
 * 
 * <p>Some lists of words can be found at 
 * <a href="https://github.com/dwyl/english-words" target="_blank">
 * https://github.com/dwyl/english-words</a>.</p>
 * @author Bradley Ross
 *
 */
public class PasswordChooser {
	protected InputStream dictionaryFile;
	protected ArrayList<String> dictionaryList = new ArrayList<String>();
	public void run() {
		try {
		readDictionary();
		} catch (IOException e) {
			return;
		}
		Random random = new Random();
		int size = dictionaryList.size();
		System.out.println("There are " + Integer.toString(size) + " entries");
		for (int i = 0; i <21; i++) {
			int loc = random.nextInt(size - 1);
			System.out.println(Integer.toString(loc) + ":" + dictionaryList.get(loc));
		}
	}
	/**
	 * This method reads the dictionary file into an ArrayList structure.  
	 * 
	 * <p>The method skips blank lines and lines containing non-alphabetic 
	 *    characters.  There is a question of how it will treat accented
	 *    alphabetic characters since I'm not sure how the REGEX
	 *    (regular expression) treats accented Unicode characters and 
	 *    alphabetic characters from other languages.  It may be necessary
	 *    to modify the string that is compiled into the regular expression.
	 * 
	 * @throws IOException
	 */
	public void readDictionary() throws IOException {
		// ClassLoader loader = this.getClass().getClassLoader();
		dictionaryFile = this.getClass().getResourceAsStream("words.txt");
		Pattern p = Pattern.compile("^[a-zA-Z]+$");
		BufferedReader reader = new BufferedReader(new InputStreamReader(dictionaryFile));
		try {
			String line;
			int counter = 0;
			while (true) {
				line = reader.readLine();
				if (line == null) { break; }
				int length = line.length();
				if (length < 3) {continue; }
				if (length > 6) { continue; }
				Matcher m = p.matcher(line);
				if (!m.matches()) {continue; }
				if (!Character.isLetter(line.charAt(0))) {continue; }
				counter++;
				if (counter > 100000) { break; }
				dictionaryList.add(line);
				if (counter % 1000 == 0) {
					System.out.println(Integer.toString(counter) + ": " + line);
				}
			}
		} catch ( IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * This is the main driver.  It may be desirable to have other
	 * drivers for applets, servlets, Swing applications, etc.
	 * @param args not used in this class
	 */
	public static void main(String[] args) {
		PasswordChooser instance = new PasswordChooser();
		instance.run();
	}
}