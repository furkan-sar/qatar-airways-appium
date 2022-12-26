package pages;

import io.appium.java_client.MobileElement;
import methods.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class BookPage {
    private final Method method=new Method();
    private final Logger logger= LogManager.getLogger(BookPage.class);
    public BookPage checkBookTabIsDisplaying() {
        Assertions.assertEquals("Let's start your trip"
                , method.findElement(By.id("com.m.qr:id/booking_activity_conversational_message")).getText()
                , "Book Tab'ine gecis yapilamadi.");
        logger.info("Book tab'ine gecis yapildi");
        return new BookPage();
    }
    public BookPage selectBookingType(boolean isReturn){
        if(isReturn){
            MobileElement mobileElement= method.findElement(By.xpath("//android.widget.LinearLayout[@content-desc='Return']"));
            mobileElement.click();
            Assertions.assertTrue(mobileElement.isSelected()
            ,"Return secilemedi");
            logger.info("Return secildi");
        }else{
            MobileElement mobileElement=method.findElement(By.xpath("//android.widget.LinearLayout[@content-desc='One-way']"));
            mobileElement.click();
            Assertions.assertTrue(mobileElement.isSelected(),"One-way secilemedi.");
            logger.info("One-way secildi.");
        }
        return new BookPage();
    }
    public AirportSelectionPage clickFromAirport(){
        method.click(By.id("com.m.qr:id/rvmp_fragment_rtow_flight_selection_origin_holder"));
        return new AirportSelectionPage();
    }
    public AirportSelectionPage clickDestinationAirport(){
        method.click(By.id("com.m.qr:id/rvmp_fragment_rtow_flight_selection_destination_holder"));
        return new AirportSelectionPage();
    }
    public DatePage clickToDate(){
        method.click(By.id("com.m.qr:id/rvmp_fragment_rtow_flight_selection_departure_date_holder"));
        return new DatePage();
    }
    public SelectDeparturePage clickSearchFlights(){
        method.click(By.id("com.m.qr:id/rvmp_booking_search_flights_button"));
        logger.info("Search flights tiklandi.");
        return new SelectDeparturePage();
    }
}