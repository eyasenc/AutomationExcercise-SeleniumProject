package src.test.pages;

import org.openqa.selenium.By;
import src.test.utilities.DriverSetup;

public class LoginPage extends BasePage {
    public By email_input_box= By.xpath("//input[@name='email']");
    public By password_input_box= By.xpath("//input[@name='password']");
    public By login_button= By.xpath("//button[@type='submit']");
    public By error_message= By.xpath("//div[@class='error']");

    public void navigateToLoginPage(){
        HomePage homePage= new HomePage();
        homePage.loadHomePage();
        homePage.clickOnElement(homePage.login_signup);
    }



}
