package test.com.umbrella.util;

import org.junit.Test;

import com.umbrella.util.Preferences;

public class PreferencesTest {
	
	@Test
	public void testGetProperty() {
		System.out.println(Preferences.getProperty("sk2"));
	}
}
