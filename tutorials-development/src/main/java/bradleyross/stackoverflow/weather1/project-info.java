package bradleyross.stackoverflow.weather1;
/**
 * A set of Java programs for a problem that occurred on StackOverflow.
 * 
 * <p>I added a statement to my.cnf to set the default time zone to UTC.  I have found that
 *    using UTC for everything provides the most consistent results when working with
 *    multiple locations.</p>
 * <p>To see values</p>
 * <ul>
 * <li>select @@session.time_zone;</li>
 * <li>select @@global.time_zone;</li>
 * </ul>
 * <p>To set values for time zone</p>
 * <ul>
 * <li>SET @@global.time_zone='+00:00';</li>
 * <li>SET @@session.time_zone='+00:00';</li>
 * </ul>
 */
