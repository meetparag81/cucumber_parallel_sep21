package DataManupulation;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.thoughtworks.selenium.Selenium;

public class TimeZoneUtility {
	private List<String> continents = null;
	
	public TimeZoneUtility() {
		String arC[] = {"europe", "asia", "america", "africa", "atlantic","australia","pacific","us"};
		continents = Arrays.asList(arC);
	}

	private String toCamelCase(String str) {
		if (str != null && !(str.trim()).equals("")) {
			str = str.trim();
			List<Character> charList = Arrays.asList(new Character[] { '-', ' ', '/', '(', ')', '_' });
			char[] chars = str.toLowerCase().toCharArray();
			for (int i = 0; i < chars.length; i++) {
				if (i == 0)
					chars[i] = Character.toUpperCase(chars[i]);
				if (charList.contains(chars[i])) {
					if ((i + 1) < chars.length && !(charList.contains(chars[i + 1]))) {
						chars[i + 1] = Character.toUpperCase(chars[i + 1]);
					}
				}
			}
			return String.valueOf(chars);
		} else
			return null;
	}

	public boolean selectTimeZone(Utilities utilities, Selenium selenium, WebDriver driver, String timezone_V,
			String timezoneXpath) throws Exception {
		boolean timeZoneSelected = false;
		utilities.waitForPresence(driver, selenium, timezoneXpath);
		WebElement Facility_TimezoneInput = driver.findElement(By.xpath(timezoneXpath));
		String F_TimeZone = toCamelCase(timezone_V);
		try {
			// By Text
			Facility_TimezoneInput.click();
			Select dropdownvalavailable = new Select(Facility_TimezoneInput);
			dropdownvalavailable.selectByVisibleText(F_TimeZone);
			timeZoneSelected = true;
		} catch (Exception e) {
			timeZoneSelected = false;
			try {
				// By value
				System.out.println("By Value");
				Facility_TimezoneInput.click();
				Select dropdownvalavailable = new Select(Facility_TimezoneInput);
				dropdownvalavailable.selectByValue(F_TimeZone);
				timeZoneSelected = true;
			} catch (Exception ex) {
				timeZoneSelected = false;
				try {
					// By Contains text
					System.out.println("By Contains Text");
					Select timeSelect = new Select(Facility_TimezoneInput);
					List<WebElement> timeOptions = timeSelect.getOptions();
					for (WebElement tOp : timeOptions) {
						String tz = tOp.getText();
						if ((tz != null) && !(continents.contains(F_TimeZone.toLowerCase())) ) {
							if ((tz.toLowerCase()).contains(F_TimeZone.toLowerCase())) {
								timeSelect.selectByVisibleText(tz);
								break;
							}
						}
					}
					timeZoneSelected = true;
				} catch (Exception exs) {
					timeZoneSelected = false;
				}
			}
		}
		return timeZoneSelected;
	}
}
