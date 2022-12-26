package pages;

import io.appium.java_client.MobileElement;
import methods.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.time.LocalDateTime;
import java.util.List;

public class DatePage {
    private final Method method=new Method();
    private final Logger logger= LogManager.getLogger(DatePage.class);
    public DatePage selectDate(LocalDateTime flightDate)
    {
        List<WebElement> webElements=method.findElements(By.xpath("//androidx.recyclerview.widget.RecyclerView"),By.xpath("//android.widget.TextView[@resource-id='com.m.qr:id/rvmp_booking_calendar_day_text_view']"));
        int today=method.getToday();
        int flightDay=flightDate.getDayOfMonth();
        for(int i=0;i<webElements.size();i++){
            if(webElements.get(i).getText().equals(String.valueOf(today))){
                for(i++;i<webElements.size();i++){
                    if(webElements.get(i).getText().equals(String.valueOf(flightDay))){
                        MobileElement mobileElement=(MobileElement)webElements.get(i);
                        mobileElement.click();
                        logger.info("Tarih secildi");
                        break;
                    }
                }
            }
        }
        return new DatePage();
    }
    public BookPage clickConfirm(){
        method.click(By.id("com.m.qr:id/fragment_calendar_confirm_button"));
        logger.info("Tarih secimi onaylandi.");
        return new BookPage();
    }
}

