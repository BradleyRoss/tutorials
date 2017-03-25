package bradleyross.stackoverflow.weather1;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import bradleyross.library.helpers.ExceptionHelper;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
/**
 * Create the database.
 * @author Bradley Ross
 *
 */
public abstract class ToolsDb implements Runnable {
	protected static Logger logger = null;
	protected static ExceptionHelper helper = null;
	protected String accountName = "sample";
	protected String password = "mypass";
	protected int portNumber = 1521;
	protected String domainName = "localhost";
	protected String handlerClass="com.mysql.jdbc.Driver";
	protected String connectionString="jdbc:mysql://localhost/sample" + 
			"?sessionVariables=sql_mode='ANSI'";
	protected Connection connection = null;
	static {
		logger = LogManager.getLogger(bradleyross.stackoverflow.weather1.ToolsDb.class);
		helper = new ExceptionHelper(logger);
	}
	protected abstract void actions() throws SQLException, IOException;
	protected void initial() { ; }
	public void run(){
		Statement statement = null;
		try
		{
			Class.forName(handlerClass).newInstance();
		}
		catch (InstantiationException e)
		{
			List<String> strings = new ArrayList<String>();
			strings.add("*** Error in establishing instance of handler");
			strings.add("*** Instantiation Exception");
			helper.error(strings, e);
			return;
		}
		catch (IllegalAccessException e )
		{
			List<String> strings = new ArrayList<String>();
			strings.add("*** Error in establishing instance of handler");
			strings.add("*** Illegal Access Exception");
			helper.error(strings, e);
			return;
		}
		catch (ClassNotFoundException e)
		{
			List<String> strings = new ArrayList<String>();
			strings.add("*** Error in establishing instance of handler");
			strings.add("*** Class Not Found Exception");
			helper.error(strings, e);
			return;
		}
		try
		{
			connection = DriverManager.getConnection(connectionString, accountName,
					password); 
			connection.setAutoCommit(true);
		}
		catch (SQLException e)
		{
			List<String> strings = new ArrayList<String>();
			strings.add("SQL Exception");
			helper.error(strings, e);
			return;
		}
		/*  First statement */
		

		try {
			if (connection == null || connection.isClosed()) {
				helper.error("Connection is not open");
				return;
			} else {
				helper.info("Database is now open");
			}
			helper.info("Running actions method");
			actions();
		} catch (SQLException e) {
			helper.error("Problem with SQL actions", e);
		} catch (RuntimeException e) {
			helper.error("RuntimeException encountered", e);
			throw e; 
		} catch (IOException e) {
			helper.error("IOException encountered", e);
		} finally {
			try {
				if (statement != null) {
					statement.close();
					connection.close();
				}
			} catch (SQLException e) {
				logger.error("Problem closing statement", e);
			}
		}
	}
}
