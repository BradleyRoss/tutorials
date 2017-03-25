package bradleyross.stackoverflow.weather1;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Date;
import java.sql.JDBCType;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.TimeZone;
import java.text.SimpleDateFormat;

public class LoadDb extends ToolsDb {

	@Override
	protected void actions() throws SQLException, IOException {
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss.SSS  zzzz");
		format.setTimeZone(TimeZone.getTimeZone("UTC"));
		int[] tempArray = {10, 0, 5, 10, 15, 20, 25, 30, 35, 40,
				45, 50, 55, 60, 65, 60, 55, 50, 45, 40,
				35, 30, 20};
		// 
		Statement stmt = connection.createStatement();
		/*
		 * This statement is supposed to set the MySQL system so that the times
		 * are viewed as TC times.
		 */
		stmt.executeUpdate("SET time_zone = '+00:00'");
		String sql = "INSERT INTO WEATHER (R_TIME, R_DATE, R_VALUE, R_LABEL, R_LOCATION)" +
				" VALUES(?, ?, ?, ?, ?)";
		if (connection == null) {
			logger.error("Connection is null");
			return;
		}
		if (connection.isClosed()) {
			logger.error("Connection is closed");
			return;
		}
		PreparedStatement statement = connection.prepareStatement(sql);
		GregorianCalendar today = new GregorianCalendar();
		today.setTimeZone(TimeZone.getTimeZone("UTC"));
		TimeZone zone = TimeZone.getTimeZone("UTC");
		System.out.println("A " + format.format(today.getTimeInMillis()));
		today.setTimeZone(zone);
		System.out.println("B " + format.format(today.getTimeInMillis()));
		today.set(Calendar.HOUR_OF_DAY, 0);
		today.set(Calendar.MINUTE, 0);
		today.set(Calendar.SECOND, 0);
		today.set(Calendar.MILLISECOND, 0);
		
		System.out.println(today.toString());
		System.out.println(format.format(today.getTimeInMillis()));
		for (int i = 0; i < 100; i++) {
			Date statementDate = new Date (today.getTimeInMillis() - (i+1)*24l*3600l*1000l);
			format.format(statementDate.getTime());
			for (int j = 0; j < 23; j++) {
				Time time = new Time(j*3600l*1000l);
				statement.setTime(1,  time);
				statement.setDate(2,  statementDate);
				statement.setInt(3, tempArray[j]);
				statement.setString(4, null);
				statement.setString(5, null);
				System.out.println(format.format(statementDate.getTime()) + "  " +  format.format(time.getTime()));
				statement.addBatch();
			}
			statement.executeBatch();
		}
		statement.close();
		connection.commit();
	}
	protected void initial() {
		logger.info("Starting program LoadDb");
	}
	public static void main(String[] args) {
		LoadDb instance = new LoadDb();
		instance.run();
	}

}
