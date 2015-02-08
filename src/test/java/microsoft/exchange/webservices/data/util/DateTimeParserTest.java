package microsoft.exchange.webservices.data.util;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(JUnit4.class)
public class DateTimeParserTest {

  private DateTimeParser parser;

  @Before
  public void setUp() {
    parser = new DateTimeParser();
  }



  // Tests for DateTimeParser.convertDateTimeStringToDate()

  @Test
  public void testDateTimeEmpty() {
    assertNull(parser.convertDateTimeStringToDate(null));
    assertNull(parser.convertDateTimeStringToDate(""));
  }

  @Test
  public void testDateTimeZulu() {
    String dateString = "2015-01-08T10:11:12Z";
    Date parsed = parser.convertDateTimeStringToDate(dateString);
    Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
    calendar.setTime(parsed);
    assertEquals(2015, calendar.get(Calendar.YEAR));
    assertEquals(0, calendar.get(Calendar.MONTH));
    assertEquals(8, calendar.get(Calendar.DATE));
    assertEquals(10, calendar.get(Calendar.HOUR_OF_DAY));
    assertEquals(11, calendar.get(Calendar.MINUTE));
    assertEquals(12, calendar.get(Calendar.SECOND));
  }

  @Test
  public void testDateTimeZuluLowerZ() {
    String dateString = "2015-01-08T10:11:12z";
    Date parsed = parser.convertDateTimeStringToDate(dateString);
    Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
    calendar.setTime(parsed);
    assertEquals(2015, calendar.get(Calendar.YEAR));
    assertEquals(0, calendar.get(Calendar.MONTH));
    assertEquals(8, calendar.get(Calendar.DATE));
    assertEquals(10, calendar.get(Calendar.HOUR_OF_DAY));
    assertEquals(11, calendar.get(Calendar.MINUTE));
    assertEquals(12, calendar.get(Calendar.SECOND));
  }

  @Test
  public void testDateTimeZuluWithPrecision() {
    String dateString = "2015-01-08T10:11:12.123Z";
    Date parsed = parser.convertDateTimeStringToDate(dateString);
    Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
    calendar.setTime(parsed);
    assertEquals(2015, calendar.get(Calendar.YEAR));
    assertEquals(0, calendar.get(Calendar.MONTH));
    assertEquals(8, calendar.get(Calendar.DATE));
    assertEquals(10, calendar.get(Calendar.HOUR_OF_DAY));
    assertEquals(11, calendar.get(Calendar.MINUTE));
    assertEquals(12, calendar.get(Calendar.SECOND));
  }

  @Test
   public void testDateTimeWithTimeZone() {
    String dateString = "2015-01-08T10:11:12+0200";
    Date parsed = parser.convertDateTimeStringToDate(dateString);
    Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
    calendar.setTime(parsed);
    assertEquals(2015, calendar.get(Calendar.YEAR));
    assertEquals(0, calendar.get(Calendar.MONTH));
    assertEquals(8, calendar.get(Calendar.DATE));
    assertEquals(8, calendar.get(Calendar.HOUR));
    assertEquals(11, calendar.get(Calendar.MINUTE));
    assertEquals(12, calendar.get(Calendar.SECOND));
  }

  @Test
  public void testDateTimeWithTimeZoneWithColon() {
    String dateString = "2015-01-08T10:11:12-02:00";
    Date parsed = parser.convertDateTimeStringToDate(dateString);
    Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
    calendar.setTime(parsed);
    assertEquals(2015, calendar.get(Calendar.YEAR));
    assertEquals(0, calendar.get(Calendar.MONTH));
    assertEquals(8, calendar.get(Calendar.DATE));
    assertEquals(12, calendar.get(Calendar.HOUR_OF_DAY));
    assertEquals(11, calendar.get(Calendar.MINUTE));
    assertEquals(12, calendar.get(Calendar.SECOND));
  }

  @Test
  public void testDateTime() {
    String dateString = "2015-01-08T10:11:12";
    Date parsed = parser.convertDateTimeStringToDate(dateString);
    Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
    calendar.setTime(parsed);
    assertEquals(2015, calendar.get(Calendar.YEAR));
    assertEquals(0, calendar.get(Calendar.MONTH));
    assertEquals(8, calendar.get(Calendar.DATE));
    assertEquals(10, calendar.get(Calendar.HOUR_OF_DAY));
    assertEquals(11, calendar.get(Calendar.MINUTE));
    assertEquals(12, calendar.get(Calendar.SECOND));
  }

  @Test
  public void testDateZulu() {
    String dateString = "2015-01-08Z";
    Date parsed = parser.convertDateTimeStringToDate(dateString);
    Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
    calendar.setTime(parsed);
    assertEquals(2015, calendar.get(Calendar.YEAR));
    assertEquals(0, calendar.get(Calendar.MONTH));
    assertEquals(8, calendar.get(Calendar.DATE));
  }

  @Test
  public void testDateOnly() {
    String dateString = "2015-01-08";
    Date parsed = parser.convertDateTimeStringToDate(dateString);
    Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
    calendar.setTime(parsed);
    assertEquals(2015, calendar.get(Calendar.YEAR));
    assertEquals(0, calendar.get(Calendar.MONTH));
    assertEquals(8, calendar.get(Calendar.DATE));
  }



  // Tests for DateTimeParser.convertDateStringToDate()

  @Test
  public void testDateOnlyEmpty() {
    assertNull(parser.convertDateStringToDate(null));
    assertNull(parser.convertDateStringToDate(""));
  }

  @Test
   public void testDateOnlyZulu() {
    String dateString = "2015-01-08Z";
    Date parsed = parser.convertDateStringToDate(dateString);
    Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
    calendar.setTime(parsed);
    assertEquals(2015, calendar.get(Calendar.YEAR));
    assertEquals(0, calendar.get(Calendar.MONTH));
    assertEquals(8, calendar.get(Calendar.DATE));
    assertEquals(0, calendar.get(Calendar.HOUR_OF_DAY));
    assertEquals(0, calendar.get(Calendar.MINUTE));
    assertEquals(0, calendar.get(Calendar.SECOND));
  }

  @Test
  public void testDateOnlyZuluWithLowerZ() {
    String dateString = "2015-01-08z";
    Date parsed = parser.convertDateStringToDate(dateString);
    Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
    calendar.setTime(parsed);
    assertEquals(2015, calendar.get(Calendar.YEAR));
    assertEquals(0, calendar.get(Calendar.MONTH));
    assertEquals(8, calendar.get(Calendar.DATE));
    assertEquals(0, calendar.get(Calendar.HOUR_OF_DAY));
    assertEquals(0, calendar.get(Calendar.MINUTE));
    assertEquals(0, calendar.get(Calendar.SECOND));
  }

  @Test
  public void testDateOnlyWithTimeZone() {
    String dateString = "2015-01-08+0200";
    Date parsed = parser.convertDateStringToDate(dateString);
    Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
    calendar.setTime(parsed);
    assertEquals(2015, calendar.get(Calendar.YEAR));
    assertEquals(0, calendar.get(Calendar.MONTH));
    assertEquals(7, calendar.get(Calendar.DATE));
    assertEquals(22, calendar.get(Calendar.HOUR_OF_DAY));
    assertEquals(0, calendar.get(Calendar.MINUTE));
    assertEquals(0, calendar.get(Calendar.SECOND));
  }

  @Test
  public void testDateOnlyWithTimeZoneWithColon() {
    String dateString = "2015-01-08-02:00";
    Date parsed = parser.convertDateStringToDate(dateString);
    Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
    calendar.setTime(parsed);
    assertEquals(2015, calendar.get(Calendar.YEAR));
    assertEquals(0, calendar.get(Calendar.MONTH));
    assertEquals(8, calendar.get(Calendar.DATE));
    assertEquals(2, calendar.get(Calendar.HOUR_OF_DAY));
    assertEquals(0, calendar.get(Calendar.MINUTE));
    assertEquals(0, calendar.get(Calendar.SECOND));
  }

  @Test
  public void testDateOnlyWithoutTimeZone() {
    String dateString = "2015-01-08";
    Date parsed = parser.convertDateStringToDate(dateString);
    Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
    calendar.setTime(parsed);
    assertEquals(2015, calendar.get(Calendar.YEAR));
    assertEquals(0, calendar.get(Calendar.MONTH));
    assertEquals(8, calendar.get(Calendar.DATE));
    assertEquals(0, calendar.get(Calendar.HOUR_OF_DAY));
    assertEquals(0, calendar.get(Calendar.MINUTE));
    assertEquals(0, calendar.get(Calendar.SECOND));
  }
}
