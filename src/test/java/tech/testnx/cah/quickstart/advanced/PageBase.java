package tech.testnx.cah.quickstart.advanced;

import org.openqa.selenium.WebDriver;

import tech.testnx.cah.AbstractPage;

/**
 * @author Yun
 *
 */
public abstract class PageBase extends AbstractPage {

    public PageBase(WebDriver driver) {
        super(driver);
    }
    
    protected PageBase() {}
    
}
