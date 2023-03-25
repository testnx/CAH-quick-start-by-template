package tech.testnx.cah.quickstart.advanced;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tech.testnx.cah.common.reports.annotations.Description;
import tech.testnx.cah.support.annotations.Executor;

/**
 * @author Yun
 *
 */
@Executor
public class AdvancedTests extends TestBase {
	
	private BingController bingController;
	private WebDriver driver;
	
    @BeforeMethod
    public void beforeMethod() {
        driver = getDriver();
        bingController = new BingController(driver);
    }
    
    @AfterMethod
    public void afterMethod() {}
    
    @Test
    @Description(testIDs = "T-001", 
    title = "Bing Search", 
    submodule = "bing", 
    description = "Search Bing by keywords ${{0}}")
    public void testBingSearch(String keywords, String expectedTitle) {
        String url = "https://bing.com";
        bingController.searchAndCheck(url, keywords, expectedTitle);
    }
}
