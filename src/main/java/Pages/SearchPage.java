package Pages;

import org.openqa.selenium.WebElement;
import java.util.List;

public class SearchPage extends BasePage{

    public JobPage collectJob(){
        List<WebElement> elements = findAllByXpath("//a[@data-qa='vacancy-serp__vacancy-title']");
        for(WebElement element : elements) {
            String url = element.getAttribute("href");
            jobList.add(url);
        }
        try {
            while (true){
                findByXpath("//a[@data-qa='pager-next']").click();
                elements = findAllByXpath("//a[@data-qa='vacancy-serp__vacancy-title']");
                for(WebElement element : elements) {
                    String url = element.getAttribute("href");
                    jobList.add(url);
                }
            }
        }catch (Exception e){
        }
        return new JobPage();
    }
}
