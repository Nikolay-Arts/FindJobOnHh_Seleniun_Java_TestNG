package Pages;

public class StartPage extends BasePage{
    public LoginPage clickOnLoginBtn(){
        findByXpath("//a[@data-qa='login']").click();
        return new LoginPage();
    }
}
