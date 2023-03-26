package tech.testnx.cah.quickstart.basic;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import tech.testnx.cah.AbstractTest;
import tech.testnx.cah.common.reports.Recorder;
import tech.testnx.cah.common.reports.annotations.Description;
import tech.testnx.cah.common.ws.RestClient;
import tech.testnx.cah.common.ws.RestfulResponse;
import tech.testnx.cah.quickstart.ModulesConfig;

/**
 * @author Yun
 *
 */
public class BasicTests extends AbstractTest {

	@Override
	public String getModuleName() {
		return ModulesConfig.BASIC_EXAMPLES.getParameter("module_name");
	}
	
	@Test
	@Description(testIDs = "T-001", 
	title = "Knock Bing By Browser",
	submodule = "UI testing",
	description = "Successful to knock bing")
	public void testKnockBingByBrowser() {
		WebDriver driver = getDriver();
		driver.get("https://bing.com");
		Assert.assertEquals(driver.getTitle(), "Bing", "Check Website tile");
	}
	
	@Test
	@Description(testIDs = "T-002", 
	title = "Knock Bing By Browser2", 
	description = "Failed to knock bing")
	public void testKnockBingByBrowser2() {
		WebDriver driver = getDriver();
		driver.get("https://bing.com");
		Assert.assertEquals(driver.getTitle(), "bing", "Check Website tile");
	}
	
	@Test
	@Description(testIDs = "T-003", 
	title = "Call API", 
	description = "Successful to call Restful API")
	public void testCallAPI() {
		RestClient client = RestClient.newInstance("https://dummy.restapiexample.com/api/v1/employees");
		RestfulResponse response = client.doGet();
		Assert.assertEquals(response.getStatus(), 200, "Check Response code");
		Assert.assertEquals(response.getJsonParser().getStringValue("status"), "success", "Check result status");
		Assert.assertEquals(response.getJsonParser().getIntValue("data[2].employee_age"), 66, "Check target employee age");
	}
	
	@Test
	@Description(testIDs = "T-004", 
	title = "Call API", 
	description = "Failed to call Restful API")
	public void testCallAPI2() {
		RestClient client = RestClient.newInstance("https://dummy.restapiexample.com/api/v1/employees");
		RestfulResponse response = client.doGet();
		Assert.assertEquals(response.getStatus(), 200, "Check Response code");
		Assert.assertEquals(response.getJsonParser().getStringValue("status"), "success", "Check result status");
		Assert.assertEquals(response.getJsonParser().getIntValue("data[2].employee_age"), 65, "Check target employee age");
	}
	
	@Test
	@Description(testIDs = "T-005", 
	title = "Data Ready", 
	description = "Test plus: ${{1}} + ${{2}} = ${{3}}?")
	public void testDataPlus(String description, int first, int second, int result) {
		Recorder.log(description);
		Assert.assertEquals(first + second, result);
	}
	
	@Test
	@Description(testIDs = "T-006", 
	title = "Data Ready2", 
	description = "Test minus: ${{1}} - ${{2}} = ${{3}}?")
	public void testDataMinus(String description, int first, int second, int result) {
		Recorder.log(description);
		Assert.assertEquals(first - second, result);
	}
}
