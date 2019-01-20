package com.naztech;

import static org.junit.Assert.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.junit.Before;
import org.junit.Test;

public class MyDateTest {
	
	
	@Before
//	public void setUp() throws Exception {
//	}

	@Test
	public void testConvertCalendarToLocalDate() throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.set(2019,Calendar.JANUARY, 1);
		LocalDate ld = LocalDate.of(2019, 1, 1);
		assertEquals(ld, MyDate.convertCalendarToLocalDate(cal));

	}

	@Test
	public void testConvertCalendarToLocalTime() {
		Calendar cal = Calendar.getInstance();
		int lh = LocalTime.now().getHour();
		int lm = LocalTime.now().getMinute();
		assertEquals(lh, MyDate.convertCalendarToLocalTime(cal).getHour());
		assertEquals(lm, MyDate.convertCalendarToLocalTime(cal).getMinute());
	}

	@Test
	public void testConvertCalendarToLocalDateTime() {
		Calendar cal = Calendar.getInstance();
		LocalDateTime d1 = LocalDateTime.now();
		assertEquals(d1.getYear(), MyDate.convertCalendarToLocalDateTime(cal).getYear());
		assertEquals(d1.getMonth(), MyDate.convertCalendarToLocalDateTime(cal).getMonth());
		assertEquals(d1.getDayOfMonth(), MyDate.convertCalendarToLocalDateTime(cal).getDayOfMonth());
		assertEquals(d1.getHour(), MyDate.convertCalendarToLocalDateTime(cal).getHour());
		assertEquals(d1.getMinute(), MyDate.convertCalendarToLocalDateTime(cal).getMinute());
	}

	@Test
	public void testUsingClaendarToFindPeriod() {
		LocalDate da2 = LocalDate.of(2019, 1, 16);
		LocalDate da1 = LocalDate.of(1895, 1, 16);
		Period p = Period.between(da1, da2);
		assertEquals(p.getYears(), MyDate.usingClaendarToFindPeriod(da1, da2).getYears());
	}

	@Test
	public void testConvertDateToLocalDate() throws Exception {
		Calendar cal = Calendar.getInstance();
		String str = "1/16/2019";
		Date d1 =MyDate.convertStringToDate(str);
		LocalDate d2 = LocalDate.of(2019, 1, 16);
		
		assertEquals(d1,MyDate.convertDateToLocalDate(d2));
	}
	
	@Test
	public void testConvertCalendarToZonedTime() {
		ZoneId zoneid = ZoneId.of("Asia/Tokyo");
		Calendar cal = Calendar.getInstance();
		ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.now(), zoneid);
		assertEquals(zonedDateTime.getHour(), MyDate.convertCalendarToZonedTime(cal, zoneid).getHour());
		assertEquals(zonedDateTime.getMinute(), MyDate.convertCalendarToZonedTime(cal, zoneid).getMinute());
	}

	@Test
	public void testConvertDateToOffsetDateTime() {
		Calendar cal = Calendar.getInstance();
		ZoneOffset offset = ZoneOffset.ofHoursMinutes(1, 30);
		OffsetDateTime dateTime = OffsetDateTime.of(LocalDateTime.of(2017, 05, 12, 05, 45),
	            ZoneOffset.ofHoursMinutes(6, 30));
		assertNotEquals(dateTime,MyDate.convertDateToOffsetDateTime(cal, offset));
		
	}

	@Test
	public void testUsingCalenderToFetchMonthDay() {
		Calendar cal = Calendar.getInstance();
		cal.set(2019,Calendar.JANUARY,3);
		LocalDate ld = LocalDate.of(2019, 1,3);
		assertEquals(ld.getDayOfMonth(), MyDate.usingCalenderToFetchMonthDay(cal));
	}

	



}
