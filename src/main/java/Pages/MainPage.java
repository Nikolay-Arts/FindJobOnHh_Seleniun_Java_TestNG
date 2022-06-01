package Pages;

public class MainPage extends BasePage{

    public FilterPage clickFilterBtn(){
        findByXpath("//a[@data-qa='advanced-search']").click();
        return new FilterPage();
    }
}
