package bradleyross.stackoverflow.weather1;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import bradleyross.library.helpers.ExceptionHelper;
import java.sql.Statement;
import java.sql.Connection;
// import java.sql.ResultSet;
// import java.sql.PreparedStatement;
import java.sql.SQLException;
// import java.sql.Driver;
import java.sql.DriverManager;
// import java.sql.Connection;
// import java.sql.ResultSet;
// import java.sql.Statement;
// import java.sql.ResultSetMetaData;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
// import java.util.Properties;
import java.util.ArrayList;
/**
 * Create the database.
 * @author Bradley Ross
 *
 */
public class BuildDb implements Runnable {
	protected static Logger logger = null;
	protected static ExceptionHelper helper = null;
	protected String accountName = "sample";
	protected String password = "mypass";
	protected int portNumber = 1521;
	protected String domainName = "localhost";
	protected String handlerClass="com.mysql.jdbc.Driver";
	protected String connectionString="jdbc:mysql://localhost/sample" + 
			"?sessionVariables=sql_mode='ANSI'";
	protected String createSql = null;
	static {
		// Properties props = System.getProperties();
		logger = LogManager.getLogger(bradleyross.stackoverflow.weather1.BuildDb.class);
		helper = new ExceptionHelper(logger);
	}
	public void run(){
		Connection connection = null;
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
			System.out.println("SQL Exception");
			System.out.println(e.getMessage());
			helper.error(strings, e);
			return;
		}
		/*  First statement */
		helper.info("Database is now open");
		try {
			InputStream stream = ClassLoader.getSystemResourceAsStream("bradleyross/stackoverflow/weather1/create.sql");
			BufferedReader in = new BufferedReader(new InputStreamReader(stream));
			StringWriter out = new StringWriter();
			BufferedWriter buffer = new BufferedWriter(out);
			while (true) {
				String line = in.readLine();
				if (line == null) { break; }
				System.out.println(line);
				buffer.write(line);
				buffer.newLine();
			}
			buffer.flush();
			createSql = out.toString();
			System.out.println("Printing SQL Statement");
			System.out.println(createSql);
		} catch (IOException e) {
			helper.info( "Error reading sql file", e);
		}
		helper.info("Creating table");
		try {
			statement = connection.createStatement();
			helper.info("Statement created");
			statement.executeUpdate(createSql);
			helper.info("Statement executed");
		} catch (SQLException e) {
			helper.error("Problem with first statement", e);
		} catch (RuntimeException e) {
			helper.error("RuntimeException encountered", e);
			throw e;
		} finally {
			try {
				if (statement != null) {
					statement.close();
					connection.close();
				}
			} catch (SQLException e) {
				helper.error("Problem closing statement", e);
			}
		}
	}
	public static void main(String[] args) {
		BuildDb instance = new BuildDb();
		instance.run();
	}
}
