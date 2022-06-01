import Pages.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class hhFindJob extends BaseTest{

    @Parameters({"login", "password"})
    @Test
    public void loginPage(String login, String password){

        new LoginPage().goToStartPage()
                .clickOnLoginBtn()
                .openPasswordInput()
                .setLogin(login)
                .setPassword(password)
                .clickLoginBtn();

    }

    @Test(dependsOnMethods = {"loginPage"})
    public void FilterPage(){
        new MainPage().clickFilterBtn()
                .hideSearchBar()
                .cleanFilter()
                .openSpecList()
                .selectSpec()
                .clickSelectBtn()
                .selectRemoteWork()
                .selectQuantity()
                .findJob();
    }

    @Test(dependsOnMethods = {"FilterPage"})
    public void collectVacancy(){
        new SearchPage().collectJob();
    }


    @Test(dependsOnMethods = {"collectVacancy"})
    @Parameters({"startMessage", "endMessage"})
    public void responseToVacancy(String startMessage, String endMessage){
        new JobPage().openJob(startMessage, endMessage);
    }
}
