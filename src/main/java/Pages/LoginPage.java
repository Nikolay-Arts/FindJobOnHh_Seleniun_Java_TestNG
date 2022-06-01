package Pages;

public class LoginPage extends BasePage{

    public LoginPage setLogin(String login){
        findByXpath("//input[@data-qa='login-input-username']").sendKeys(login);
        return this;
    }

    public LoginPage openPasswordInput(){
        findByXpath("//button[@data-qa='expand-login-by-password']").click();
        return this;
    }

    public LoginPage setPassword(String password){
        findByXpath("//input[@data-qa='login-input-password']").sendKeys(password);
        return this;
    }

    public LoginPage clickLoginBtn(){
        findByXpath("//button[@data-qa='account-login-submit']").click();
        return this;
    }


}
