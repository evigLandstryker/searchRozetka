import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/katerinasalamatina/Desktop/selenium/searchRozetka//src/main/resources/chromedriver");

        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://www.google.com.ua");
        By inputGoogleField = By.xpath("//input[@type='text']");
        WebElement inputGoogleRequest = driver.findElement(inputGoogleField);
        inputGoogleRequest.clear();
        inputGoogleRequest.sendKeys("https://rozetka.com.ua");

        By buttonSearchGoogle = By.xpath("//input[@type='submit' and @class='gNO89b']");
        WebElement clickButtonSearchGoogle = driver.findElement(buttonSearchGoogle);
        clickButtonSearchGoogle.submit();

        By rozetkaSearched = By.xpath("//div[@class=\"yuRUbf\"]");
        WebElement goToRozetka = driver.findElement(rozetkaSearched);
        goToRozetka.click();

        By searchFieldRozetka = By.cssSelector("input[class^=search]");
        WebElement inputRozetkaSearch = driver.findElement(searchFieldRozetka);
        inputRozetkaSearch.clear();
        inputRozetkaSearch.sendKeys("Монитор");

        By clickButtonSearchRozetka = By.cssSelector("button[class~=search-form__submit]");
        WebElement searchButtonRozetka = driver.findElement(clickButtonSearchRozetka);
        searchButtonRozetka.click();

        By firstItemSearced = By.cssSelector("span[class~=goods-tile__title]");
        WebElement nameFirstItemSearched = driver.findElement(firstItemSearced);
        String nameFirstElement = nameFirstItemSearched.getText();
        if (nameFirstElement.contains("Mонитор")){
            System.out.println("PASS");
        }
        else{
            System.out.println("FAIL");
        }

        driver.quit();

    }
}
