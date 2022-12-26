package pages;

import methods.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class TripSummaryPage {
    private final Method method = new Method();
    private final Logger logger = LogManager.getLogger(TripSummaryPage.class);

    public void checkDepartureTime() {
        Assertions.assertEquals(SelectDeparturePage.departureTime
                , method.findElement(By.id("com.m.qr:id/from_time")).getText()
                , "Secilen kalkis saati ile ekrandaki ayni degil.");
        logger.info("Secilen kalkis saat ile ekrandaki saat ayni.");
    }
}