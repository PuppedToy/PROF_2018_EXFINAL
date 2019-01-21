package es.upm.grise.profundizacion2018.examenFinal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

public class GreetingTest {
	
	private Calendar morning_calendar;
	
	@Before
	public void before() {
		morning_calendar = mock(MyCalendar.class);
		when(morning_calendar.get(Calendar.HOUR_OF_DAY)).thenReturn(10);
	}

	@Test
	public void smokeTest1() {
		Greeting greeting = new Greeting();
		assertEquals("Good morning", greeting.getGreeting(null, morning_calendar));
	}
	
	@Test
	public void smokeTest2() {
		Greeting greeting = new Greeting();
		assertEquals("Good morning", greeting.getGreeting(Language.ENGLISH, morning_calendar));
	}
	
	@Test
	public void smokeTest3() {
		Greeting greeting = new Greeting();
		assertEquals("Buenos días", greeting.getGreeting(Language.SPANISH, morning_calendar));
	}

}
