import org.openqa.selenium.WebDriver;
import MyWebDriver.MyDriverManager;
import org.testng.annotations.AfterTest;


public class BaseTest {
    protected static WebDriver driver = MyDriverManager.getDriver();

    @AfterTest
    public void end(){
        driver.close();
        driver.quit();
    }
}
