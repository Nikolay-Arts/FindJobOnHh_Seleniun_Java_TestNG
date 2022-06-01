package Pages;
import MyWebDriver.MyDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class BasePage {

    protected JavascriptExecutor js = (JavascriptExecutor) driver;

    public static List<String> jobList = new ArrayList<>();

    protected String startPage="https://hh.ru/";

    protected static WebDriver driver;

    public BasePage(){
        this.driver = MyDriverManager.getDriver();
    }

    public WebElement findByXpath(String xpath, long seconds){
        return driver.findElement(waitForElementVisible(By.xpath(xpath), Duration.ofSeconds(seconds).getSeconds()));
    }

    public WebElement findByXpath(String xpath){
        return driver.findElement(waitForElementVisible(By.xpath(xpath), Duration.ofSeconds(10).getSeconds()));
    }

    public List<WebElement> findAllByCss(String css){
        return driver.findElements(By.cssSelector(css));
    }

    public List<WebElement> findAllByXpath(String xpath){
        return driver.findElements(By.xpath(xpath));
    }

    public StartPage goToStartPage() {
        MyDriverManager.getDriver().get(startPage);
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                driver.close();
                driver.switchTo().window(originalWindow);
            }
        }
        return new StartPage();
    }

    private WebDriverWait getWaiter(long timeOutInSecond){
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSecond));
        webDriverWait.ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(StaleElementReferenceException.class);
        return webDriverWait;
    }

    public By waitForElementVisible(By findStrategy, long timeOutInSecond){
        getWaiter(timeOutInSecond).until(visibilityOfElementLocated(findStrategy));
        return findStrategy;
    }

}
