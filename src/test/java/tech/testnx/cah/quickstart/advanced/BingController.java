package tech.testnx.cah.quickstart.advanced;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import tech.testnx.cah.support.annotations.Controller;
import tech.testnx.cah.support.annotations.Step;

/**
 * @author Yun
 *
 */
@Controller
public class BingController extends ControllerBase {
	
	private BingSearchPO bingSearchPO;
	private WebDriver driver;

    public BingController(WebDriver driver) {
        this.driver = driver;
        bingSearchPO = new BingSearchPO(driver);
    }
    
    protected BingController() {}
    
    @Step(description = "Search Bing and check result", retry = 2, intervalWaitInSecond = 3)
    public void searchAndCheck(String url, String keywords, String expectedTitle) {
        driver.get(url);
        bingSearchPO.search(keywords);
        String result = bingSearchPO.getResultTitle();
        logger.debug("Search result title: " + result);
        Assert.assertTrue(result.equalsIgnoreCase(expectedTitle));
    }
}
