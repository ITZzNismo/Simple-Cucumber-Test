package cuke;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/cucumber", 
plugin = {"pretty", "html:src/test/resources/reports/htmlReport"},
monochrome = true)
public class testRunner 
{
	
}
