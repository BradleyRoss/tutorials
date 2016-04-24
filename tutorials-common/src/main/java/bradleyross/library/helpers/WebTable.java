package bradleyross.library.helpers;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSetMetaData;
import java.io.IOException;
public abstract class WebTable implements TableInterface
{
	protected GenericPrinter output = null;
	protected int debugLevel = 0;
	protected int columnCount = 0;
	protected int rowCount = 0;
	public void finishRow() throws IOException
	{
		output.println("</tr>");
	}
	public void finishTable() throws IOException
	{
		output.println("</table>");

	}
	public void formatCell(Object value) throws IOException
	{
		formatCell(value, NORMAL);
	}
	public void formatCell(Object value, int format) throws IOException
	{
		output.println("<td>" + value.toString() + "</td>");

	}

	public void formatDataRow(Object...values) throws IOException
	{
		startRow();
		for (int i = 0; i < values.length; i++)
		{
			formatCell(values[i]);
		}
		finishRow();
	}
	public void formatDataRow(ResultSet rs) throws SQLException, IOException
	{
		startRow();
		for (int i = 1; i <= getColumnCount(); i++)
		{
			formatCell(rs.getString(i));
		}
		finishRow();
	}

	public void formatHeaderRow(Object... values) throws IOException
	{
		startRow();
		for (int i = 0; i < values.length; i++)
		{
			formatCell(values[i]);
		}
		finishRow();
	}
	public void formatHeaderRow(ResultSet rs) throws SQLException, IOException
	{
		ResultSetMetaData meta = rs.getMetaData();
		startRow();
		for (int i = 0; i <= getColumnCount(); i++)
		{
			formatCell(meta.getColumnName(i));
		}
		finishRow();
	}
	public int getColumnCount() 
	{
		return columnCount;
	}

	public int getDebugLevel() 
	{
		return debugLevel;
	}

	public void setColumnCount(int value) 
	{
		columnCount = value;

	}
	public void setDebugLevel(int value) 
	{
		debugLevel = value;

	}
	public void startRow() throws IOException
	{
		rowCount++;
		output.println("<tr>");
	}
	public void startTable() throws IOException
	{
		output.println("<table border=\"1\">");

	}
	public void setOutput(GenericPrinter value) 
	{
		output = value;
		
	}

}
