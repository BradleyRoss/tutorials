package bradleyross.library.tools;
import java.io.FileFilter;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import bradleyross.library.helpers.DirWalker;
/**
 * @author Bradley Ross
 *
 */
public class RepositoryReview {
	protected File fileRoot;
	protected FileFilter fileFilter;
	protected Iterator<File> iterator;
	protected Logger logger = LogManager.getLogger(RepositoryReview.class);
	public RepositoryReview() {
		logger.info("Starting RepositoryReview class");
		fileFilter = new PomFilter();
		String userDir = System.getProperty("user.home");
		fileRoot = new File(userDir, ".m2/repository");
		try {
			logger.info(fileRoot.getCanonicalPath());;
		} catch (IOException e) {
			logger.warn("Problem get root file");
		}
		try {
			logger.info("Root directory is " + fileRoot.getCanonicalPath());
			iterator = new DirWalker(fileRoot, fileFilter);
		} catch (IOException e) {
			logger.error("Error creating directory walker", e);
		}
	}
	public RepositoryReview(File root,  FileFilter filter) {
		logger.info("Starting RepositoryReview class");
		fileFilter = filter;
		fileRoot = root;
		try {
			iterator = new DirWalker(fileRoot, fileFilter);
		} catch (IOException e) {
			logger.error("Error creating directory walker", e);
		}
	}
	protected class PomFilter implements FileFilter {
		public boolean accept(File pathname) {
			if (pathname.exists() &&
					pathname.isFile() &&
					pathname.getName().equalsIgnoreCase("pom.xml")) {
				return true;
			} else {
				return false;
			}
		}
	}
	public void run() {

		while (iterator.hasNext()) {
			File item = iterator.next();
			try {
				System.out.println(item.getCanonicalPath());
			} catch (IOException e) {
				logger.error("Error while processing iterator", e);
			}
		}
	}
	/**
	 * Test driver
	 * @param args not used in this class
	 */
	public static void main(String[] args) {
		RepositoryReview instance = new RepositoryReview();
		instance.run();
	}

}
