package es.upm.grise.profundizacion2018.examenFinal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

public class GreetingTest {
	
	private Calendar morning_calendar;
	private Message message;
	
	@Before
	public void before() {
		morning_calendar = mock(MyCalendar.class);
		message = mock(Message.class);
		when(message.getDefaultLanguage()).thenReturn(Language.ENGLISH);
		// This is needed only for tests 4 and 5
		when(message.getMessage(TimeOfTheDay.MORNING, Language.ENGLISH)).thenReturn("Good morning");
		when(morning_calendar.get(Calendar.HOUR_OF_DAY)).thenReturn(10);
	}

	@Test
	public void smokeTest1() {
		Greeting greeting = new Greeting();
		assertEquals("Good morning", greeting.getGreeting(null, morning_calendar, new Message()));
	}
	
	@Test
	public void smokeTest2() {
		Greeting greeting = new Greeting();
		assertEquals("Good morning", greeting.getGreeting(Language.ENGLISH, morning_calendar, new Message()));
	}
	
	@Test
	public void smokeTest3() {
		Greeting greeting = new Greeting();
		assertEquals("Buenos días", greeting.getGreeting(Language.SPANISH, morning_calendar, new Message()));
	}
	
	// I don't know how to test static methods, so I have created an instance of Message
	@Test
	public void smokeTest4() {
		Greeting greeting = new Greeting();
		assertEquals("Good morning", greeting.getGreeting(null, morning_calendar, message));
		verify(message).getDefaultLanguage();
	}
	
	@Test
	public void smokeTest5() {
		Greeting greeting = new Greeting();
		assertEquals("Good morning", greeting.getGreeting(Language.ENGLISH, morning_calendar, message));
		verify(message).getMessage(TimeOfTheDay.MORNING, Language.ENGLISH);
		verify(message, never()).getDefaultLanguage();
	}

}
