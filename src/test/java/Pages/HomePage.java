package Pages;

public class HomePage extends BasePage {
    public String url = "https://automationexercise.com/";
    public String title = "Automation Exercise";
    public By login_signup = By.xpath("//a[contains(text(),'Login / Signup')]");
    public By logout_button = By.xpath("//a[contains(text(),'Logout')]");

    public void loadHomePage() {
        loadAWebPage(url);



    }
}
