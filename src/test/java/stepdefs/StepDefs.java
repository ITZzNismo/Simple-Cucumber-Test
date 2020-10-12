package stepdefs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefs 
{
	public static WebDriver driver;
	
	public String url = "https://www.google.com/";
	public String searchTerm = "Kittens";
	
	public static ChromeOptions chromeCFG()
	{
		Map<String, Object> prefs = new HashMap<String, Object>();
		ChromeOptions cOptions = new ChromeOptions();
		
		// Settings
		prefs.put("profile.default_content_setting_values.cookies", 2);
		prefs.put("network.cookie.cookieBehavior", 2);
		prefs.put("profile.block_third_party_cookies", true);
		
		// Create ChromeOptions to disable cookies pop-up
		cOptions.setExperimentalOption("prefs", prefs);
		return cOptions;
	}
	
    @Before
    public void setup() 
    {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver(chromeCFG());
    }
	
	@Given("^we can open google$")
	public void we_can_open_google()
	{
    	driver.get(url);
    	String expected = url;
    	String actual = driver.getCurrentUrl();
    	assertEquals(expected, actual);
	}

	@When("^we search for kittens$")
	public void we_search_for_kittens() throws Throwable
	{
		Thread.sleep(1500);
    	WebElement search = driver.findElement(By.name("q"));
    	search.sendKeys(searchTerm);
    	Thread.sleep(1500);
    	search.submit();
    	Thread.sleep(1500);
    	WebElement images = driver.findElement(By.xpath("//*[@id=\"hdtb-msb-vis\"]/div[2]/a"));
    	images.click();
    	Thread.sleep(1500);
	}

	@Then("^google will return us images of kittens$")
	public void google_will_return_us_images_of_kittens()
	{
		WebElement image = driver.findElement(By.xpath("//*[@id=\"islrg\"]/div[1]/div[1]/a[1]/div[1]/img"));
		Boolean hasImage = image.getAttribute("src").contains("image");
		assertTrue(hasImage);
	}
	
	@After
	public void close()
	{
		driver.close();
		driver.quit();
	}
}