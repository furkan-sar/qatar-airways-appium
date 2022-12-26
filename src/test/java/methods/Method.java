package methods;

import driver.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class Method {
    private FluentWait<AppiumDriver> driver;
    public Method(){
        driver=new FluentWait<>(BaseTest.appiumDriver);
        driver.withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class);
    }
    public MobileElement findElement(By selector){
        return (MobileElement) driver.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }
    public List<WebElement> findElements(By parentLocator,By childLocator){
        return driver.until(ExpectedConditions.presenceOfNestedElementsLocatedBy(parentLocator,childLocator));
    }
    public void click(By selector){
        waitUntilClickable(findElement(selector)).click();
    }
    public void sendKeys(By selector,String text){
        findElement(selector).sendKeys(text);
    }
    public MobileElement waitUntilClickable(MobileElement mobileElement){
        return (MobileElement) driver.until(ExpectedConditions.elementToBeClickable(mobileElement));
    }
    public boolean isElementVisible(By selector){
        try{
            driver.until(ExpectedConditions.visibilityOfElementLocated(selector));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public int getToday(){
        return LocalDateTime.now().getDayOfMonth();
    }
}
