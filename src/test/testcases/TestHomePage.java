package src.test.testcases;
import org.testng.annotations.Test;
import org.testng.Assert;
import src.test.pages.HomePage;
import src.test.utilities.DriverSetup;

public class TestHomePage extends DriverSetup {
    HomePage homePage = new HomePage();

    @Test
    public void testHomePageUrl(){
        getDriver().get(homePage.url);
        Assert.assertEquals(homePage.getLoadedPageUrl(),homePage.url);
    }

    @Test
    public void testHomePageTitle() {
        getDriver().get(homePage.url);
        Assert.assertEquals(homePage.getLoadedPageTitle(),homePage.title);

    }
}
