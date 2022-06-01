package MyWebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyDriverManager {

    private static WebDriver driver;

    private static void setDriver(){
        driver = new ChromeDriver(MyDriverOptions.chromeDriver());
    }

    public static WebDriver getDriver(){
        if(driver == null){
            setDriver();
        }
        return driver;
    }
}
