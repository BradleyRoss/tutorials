package bradleyross.library.helpers.tests;
import java.io.IOException;
import bradleyross.library.helpers.WebTable;
import bradleyross.library.helpers.GenericPrinter;
public class TestWebTable extends WebTable
{
	public static void main (String args[])
	{
		try {
			TestWebTable instance = new TestWebTable();
			GenericPrinter out = new GenericPrinter(System.out);
			instance.setOutput(out);
			instance.startTable();

			instance.setColumnCount(4);
			instance.formatHeaderRow("First", "Second", "Third", "Fourth");
			instance.finishTable();
		} catch (IOException e) {
			System.out.println(e.getClass().getName() + " " + e.getMessage());
			e.printStackTrace();
		}
	}
}
