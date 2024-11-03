package src.test.testcases;
import org.testng.annotations.Test;
import src.test.pages.HomePage;
import src.test.pages.LoginPage;
import src.test.utilities.DriverSetup;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class TestLogin extends DriverSetup {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void loadTestPage(){
        loginPage.navigateToLoginPage();
    }
    @Test
    public void testLoginWithValidCredentials(){
        loginPage.writeOnElement(loginPage.email_input_box, "ticah56767@cartep.com");
        loginPage.writeOnElement(loginPage.password_input_box, "01675651634");
        loginPage.clickOnElement(loginPage.login_button);
        Assert.assertTrue(homePage.is_element_visible(homePage.logout_button));
        Assert.assertFalse(loginPage.is_element_visible(loginPage.login_button));

    }
}
