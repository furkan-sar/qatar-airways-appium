package pages;

import methods.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class FlightDetailsPage {
    private final Logger logger= LogManager.getLogger(FlightDetailsPage.class);
    private final Method method=new Method();

    public TripSummaryPage selectFare(){
        method.click(By.id("com.m.qr:id/rvmp_activity_flight_details_select_button"));
        logger.info("Ucus secildi.");
        return new TripSummaryPage();
    }
}
