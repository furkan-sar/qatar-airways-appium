package pages;

import methods.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class AirportSelectionPage {
    private final Method method=new Method();
    private final Logger logger= LogManager.getLogger(AirportSelectionPage.class);
    public BookPage selectFromAirport(String airportName){
        method.sendKeys(By.id("com.m.qr:id/rvmp_fragment_ond_selection_filter_edittext"),airportName);
        method.click(By.xpath("//android.widget.TextView[contains(@text, '"+airportName+"')]"));
        logger.info(String.valueOf(new StringBuilder().append(airportName).append(" havaalani secildi.")));
        return new BookPage();
    }
    public BookPage selectDestinationAirport(String airportName){
        method.sendKeys(By.id("com.m.qr:id/rvmp_fragment_ond_selection_filter_edittext"),airportName);
        method.click(By.xpath("//android.widget.TextView[contains(@text, '"+airportName+"')]"));
        logger.info(String.valueOf(new StringBuilder().append(airportName).append(" havaalani secildi.")));
        return new BookPage();
    }
}
