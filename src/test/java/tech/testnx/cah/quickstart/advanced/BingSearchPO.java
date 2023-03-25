package tech.testnx.cah.quickstart.advanced;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import tech.testnx.cah.common.utils.Utilities;
import tech.testnx.cah.support.annotations.Action;
import tech.testnx.cah.support.annotations.Operator;

/**
 * @author Yun
 *
 */
@Operator
public class BingSearchPO extends PageBase {

    @FindBy(name = "q")
    private WebElement searchbox;
    
    @FindBy(id = "search_icon")
    private WebElement searchButton;
	
    public BingSearchPO(WebDriver driver) {
        super(driver);
    }
    
    protected BingSearchPO() {}
	
	@Override
	public void waitForReady() {}
	
    /**
     * Action: Search Bing by keywords
     */
    @Action(description = "Search Bing by Keywords: ${{0}}", retry = 2, intervalWaitInSecond = 3)
    public void search(String keywords) {
    	waitForReadyAndCapturePagePerf();
        searchbox.clear();
        searchbox.sendKeys(keywords);
        Utilities.timeUtility.sleep(2);
        searchButton.click();
    }
    
    /**
     * Action: Get result title
     */
    @Action(description = "Get result title", retry = 2, intervalWaitInSecond = 3)
    public String getResultTitle() {
    	waitForReadyAndCapturePagePerf();
    	return driver.getTitle();
    }
}
