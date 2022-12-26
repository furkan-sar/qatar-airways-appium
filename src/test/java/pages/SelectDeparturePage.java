package pages;

import methods.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Random;


public class SelectDeparturePage {
    private final Method method = new Method();
    private final Logger logger = LogManager.getLogger(SelectDeparturePage.class);

    public static String departureTime;
    public static String arrivalTime;

    public SelectDeparturePage checkSelectDeparturePageIsVisible() {
        Assertions.assertTrue(method.isElementVisible(By.xpath("//android.widget.TextView[@text='Select your departure']")),
                "Ucus secim ekranina yonlendirilemedi.");
        logger.info("Ucus secim ekranina yonlendirildi.");
        return new SelectDeparturePage();
    }

    public FlightDetailsPage selectDeparture() {
        List<WebElement> departures = method.findElements(By.className("androidx.recyclerview.widget.RecyclerView"), By.className("android.view.ViewGroup"));
        WebElement randomDepature = departures.get(new Random().nextInt(departures.size()));
        departureTime = randomDepature.findElement(By.xpath("//android.widget.TextView[@resource-id='com.m.qr:id/rvmp_departure_time']")).getText();
        arrivalTime = randomDepature.findElement(By.xpath("//android.widget.TextView[@resource-id='com.m.qr:id/rvmp_arrival_time']")).getText();
        randomDepature.click();
        logger.info("Rastgele bir ucus secildi.");
        return new FlightDetailsPage();
    }
}