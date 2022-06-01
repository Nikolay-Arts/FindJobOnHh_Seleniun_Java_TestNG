package Pages;

public class JobPage extends BasePage{
    public void openJob(String startMessage, String endMessage){
        System.out.println(jobList.size());
        String originalWindow = driver.getWindowHandle();
        for(String element : jobList){
            js.executeScript("window.open('"+element+"')");
            for (String windowHandle : driver.getWindowHandles()) {
                if (!originalWindow.contentEquals(windowHandle)) {
                    driver.switchTo().window(windowHandle);
                }
            }
            try {
                String name = findByXpath("//h1[@data-qa='vacancy-title']").getText();
                System.out.println(name);
                findByXpath("//a[@data-qa='vacancy-response-link-top']").click();
                findByXpath("//div[@class='bloko-gap bloko-gap_right']/descendant::span[text()='Тестировщик ПО']").click();
                findByXpath("//button[@data-qa='vacancy-response-letter-toggle']").click();
                findByXpath("//textarea[@data-qa='vacancy-response-popup-form-letter-input']").sendKeys(startMessage + name + endMessage);
                findByXpath("//button[@class='bloko-button bloko-button_kind-primary']").click();
            }catch (Exception e){
            }
            for (String windowHandle : driver.getWindowHandles()) {
                if (!originalWindow.contentEquals(windowHandle)) {
                    driver.switchTo().window(windowHandle);
                    driver.close();
                    driver.switchTo().window(originalWindow);
                }
            }
        }
    }
}
