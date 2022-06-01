package Pages;

import org.openqa.selenium.WebElement;
import java.util.List;

public class FilterPage extends BasePage{

    public FilterPage cleanFilter(){
        List<WebElement> elements = findAllByCss(".bloko-tag-button12");
        for(WebElement element : elements){
            element.click();
        }
        return this;
    }

    public FilterPage hideSearchBar(){
        js.executeScript("document.querySelector('.search-submit-wrapper').setAttribute('style', 'position:static')");
        return this;
    }

    public FilterPage openSpecList(){
        findByXpath("//button[@data-qa='resumesearch__profroles-switcher']").click();
        return this;
    }

    public FilterPage selectSpec(){
        findByXpath("//span[contains(@data-qa,'node-category-11')]").click();
        findByXpath("//span[text()='Тестировщик']").click();
        return this;
    }

    public FilterPage clickSelectBtn(){
        findByXpath("//div[@class='bloko-tree-selector-popup-footer']/descendant::span[text()='Выбрать']").click();
        return this;
    }

    public FilterPage selectRemoteWork(){
        findByXpath("//span[text()='Удаленная работа']").click();
        return this;
    }

    public FilterPage selectQuantity(){
        findByXpath("//span[text()='100 вакансий']").click();
        return this;
    }

    public FilterPage findJob(){
        findByXpath("//input[@id='submit-bottom']").click();
        return this;
    }
}
