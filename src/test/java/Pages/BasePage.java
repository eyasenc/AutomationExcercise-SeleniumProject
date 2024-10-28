package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Utilities.DriverSetup.getDriver;

public class BasePage {
    // finds and returns a web element using a given locator(e.g By.if, By.name)
    public WebElement getElement(By locator){
        return getDriver().findElement(locator);
    }
    //clicks on a web element specified by the locator
    public void clickOnElement(By locator){
        getElement(locator).click();
    }
    // Returns the URL of the currently loaded page
    public void writeOnElement(By locator, String text){
        getElement(locator).sendKeys(text);
    }
    // Returns the title of the currently loaded page
    public String getLoadedPageUrl(){
        return getDriver().getCurrentUrl();
    }
    // Loads a web page by navigating to a specified URL
    public void loadAWebPage(String url){
        getDriver().get(url);
    }
    // Checks if an element is visible on the page
    // Returns true if the element is displayed, otherwise returns false
    public  Boolean is_element_visible(By locator){
        try {
            return getElement(locator).isDisplayed();
        }catch(Exception e){
            return false;

        }
    }

}
