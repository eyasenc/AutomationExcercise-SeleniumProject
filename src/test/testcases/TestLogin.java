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
    @Test
    public void testLoginWithInvalidPassword(){
        loginPage.writeOnElement(loginPage.email_input_box, "invalid@gmail.com");
        loginPage.writeOnElement(loginPage.password_input_box, "password123");
        loginPage.clickOnElement(loginPage.login_button);
        Assert.assertEquals(loginPage.getElement(loginPage.error_message).getText(),"Your email or password is incorrect!");
        Assert.assertTrue(loginPage.is_element_visible(loginPage.login_button));
    }
    @Test
    public void testLoginWithInvalidEmailAndPassword(){
        loginPage.writeOnElement(loginPage.email_input_box, "invalidemail@gmail.com");
        loginPage.writeOnElement(loginPage.password_input_box, "Password1");
        loginPage.clickOnElement(loginPage.login_button);
        Assert.assertEquals(loginPage.getElement(loginPage.error_message).getText(), "Your email or password in incorrect!");
        Assert.assertTrue(loginPage.is_element_visible(loginPage.login_button));
    }
    @Test
    public void testLoginWithInvalidEmailAndValidPassword(){
        loginPage.writeOnElement(loginPage.email_input_box,"invalidemail@gmail.com");
        loginPage.writeOnElement(loginPage.password_input_box, "01675651634");
        loginPage.clickOnElement(loginPage.login_button);
        Assert.assertEquals(loginPage.getElement(loginPage.error_message).getText(), "Your email or password is incorrect!");
        Assert.assertTrue(loginPage.is_element_visible(loginPage.login_button));
    }
    @Test
    public void testLoginEmailAndWithoutPasssword(){
        loginPage.writeOnElement(loginPage.email_input_box,"ticah56767@cartep.com");
        loginPage.writeOnElement(loginPage.password_input_box, "");
        loginPage.clickOnElement(loginPage.login_button);
        Assert.assertEquals(loginPage.getElement(loginPage.password_input_box).getAttribute("validationMessage"), "Please fill out this field");
        Assert.assertTrue(loginPage.is_element_visible(loginPage.login_button));
    }
    Object[][] data ={
            {"ticah56767@cartep.com", ""},
            {"ticah56767@cartep.com", "Pass&Pas", "Your email or password is incorrect!", ""},
            {"ticah56767@cartep.com", "Pass&Pas", "Your email or password is incorrect!", ""},
            {"ticah56767@cartep.com", "Pass&Pass!", "Your email or password is incorrect!", ""},
            {"", "", "", "Please fill out this field."},
            {"ticah56767@cartep.com", "", "","Your email or password is incorrect!"}

    };


}
