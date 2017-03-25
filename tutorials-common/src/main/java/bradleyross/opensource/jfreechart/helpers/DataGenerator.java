package bradleyross.opensource.jfreechart.helpers;
import java.util.Date;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.Second;
/**
 * Creates sets of sample data for testing of the JFreeChart product.
 * @author Bradley Ross
 *
 */
@SuppressWarnings("deprecation")
public class DataGenerator 
{
	/**
	 * Since all of the methods are static, the constructor should
	 * never be used.
	 */
	protected DataGenerator()
	{ ; }
	/**
	 * Generate data according to a sine wave.
	 * @param name name for data set
	 * @param wavelength Wavelength of sine wave in milliseconds
	 * @param duration Duration for which series is to be generated in milliseconds
	 * @param interval Interval between data points in milliseconds - The value must be 
	 *        greater than or equal to one second
	 * @param magnitude maximum magnitude
	 * @param offset offset from 0
	 * @return TimeSeries containing data values
	 */
	public static TimeSeries generateSine(String name, long wavelength, long duration, long interval,
			double magnitude, double offset)	
	{
		return  generateSine(name, wavelength, duration, interval,
				magnitude, offset, new java.util.Date());
	}
	/**
	 * Generate data according to a sine wave.
	 * @param name name o chart
	 * @param wavelength Wavelength of sine wave in milliseconds
	 * @param duration Duration for which series is to be generated in milliseconds
	 * @param interval Interval between data points in milliseconds - The value must be 
	 *        greater than or equal to one second
	 * @param offset offset of middle amplitude of waveform from zero
	 * @param startTime Starting time for plot
	 * @param magnitude maximum of wave
	 * @return TimeSeries containing data values
	 */
	public static TimeSeries generateSine(String name, long wavelength, long duration, long interval,
			double magnitude, double offset, java.util.Date startTime)
	{
		TimeSeries working = new TimeSeries(name, Second.class );
		long now = startTime.getTime();
		for (long i = now; i < now + duration; i=i+interval)
		{
			working.add(new Second(new Date(i)),
					magnitude*Math.sin(2.0d*Math.PI*(double) (i - now)/(double) wavelength) + offset);
		}
		return working;
	}
}
