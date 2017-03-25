package bradleyross.opensource.xerces;
import java.io.File;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
/**
 * This is a demonstration of XML parsing.
 * 
 * <p>It reads a file as a resource and parses it as an XML file.</p>
 * <p>http://stackoverflow.com/questions/9429037/getting-encoding-type-of-a-xml-in-java</p>
 * <p>https://commons.apache.org/proper/commons-io/javadocs/api-2.4/org/apache/commons/io/input/XmlStreamReader.html</p>
 * @author Bradley Ross
 *
 */
public class TestXmlParser {
	protected class MyHandler extends DefaultHandler
	{
		@Override
		public void startDocument() throws SAXException {
			System.out.println("Starting document");
		}
		@Override
		public void endDocument() throws SAXException {
			System.out.println("End of document");
		}
		@Override
		public void startPrefixMapping(String prefix, String uri) throws SAXException {
			System.out.println("startPrefixMapping " + prefix + " " + uri);
		}
		@Override
		public void endPrefixMapping(String prefix) throws SAXException {
			System.out.println("endPrefixMapping " + prefix);
		}
		@Override
		public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
			System.out.println();
			System.out.println("Starting element " + uri + " " + localName +
					" " + qName);
			Attributes attributes = atts;
			if (attributes.getLength() > 0) {
				for (int i = 0; i < attributes.getLength(); i++) {
					System.out.println("Attribute " + Integer.toString(i) + ":" + attributes.getQName(i) +
							" " + attributes.getType(i) + " " + attributes.getValue(i));
				}
			}
		}
		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			System.out.println();
			System.out.println("Ending element " + uri + " " + localName +
					" " + qName);		
		}
		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			System.out.println();
			System.out.println("Processing characters " + Integer.toString(start) +
					" " + Integer.toString(length));
			if (length == 1) {
				System.out.print("Character is " + Integer.toString((int) ch[start]));
			} else {
				for (int i = start; i <= start + length - 1; i++) {
					System.out.print(ch[i]);
				}
			}
			System.out.println();
		}
		@Override
		public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
			System.out.println("Ignorable whitespace " + Integer.toString(start) +
					" " + Integer.toString(length));
			if (length == 1) {
				System.out.println("Character is " + Integer.toString((int) ch[start]));
			} else {
				for (int i = start; i <= start + length - 1; i++) {
					System.out.print(ch[i]);
				}
			}
			System.out.println();
		}
		@Override
		public void processingInstruction(String target, String data) throws SAXException {
			System.out.println("ProcessingInstruction " + target + " " + data);

		}

		public void skippedEntity(String name) throws SAXException {
			System.out.println("Skipped entity " + name);

		}

	}
	/**
	 * Carries out the actual parsing.
	 * 
	 * @see FileInputStream
	 * @see SAXParserFactory
	 * @see SAXParser
	 * @see XMLStreamReader
	 */
	protected void runParser() {
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser parser = null;
		try 
		{
			parser = spf.newSAXParser();
		}
		catch (ParserConfigurationException e) {
			e.getStackTrace();
		}
		catch (SAXException e)
		{
			System.out.println ("SAXException error when creating XMLReader");
			e.getStackTrace();
		}
		try
		{
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource("bradleyross/opensource/xerces/utf.xml").getFile());
			// parser.parse(new FileInputStream("utf.xml"), new MyHandler());
			parser.parse(new FileInputStream(file), new MyHandler());
		}
		catch (SAXException e)
		{
			System.out.println ("SAXException while parsing");
			e.getStackTrace();
		}
		catch (IOException e)
		{
			System.out.println ("IOException while parsing");
			e.getStackTrace();
		}
	}
	/**
	 * Main driver.
	 * @param args not used in this case
	 */
	public static void main(String[] args) {
		TestXmlParser instance = new TestXmlParser();
		instance.runParser();
	}
}



