package test;

import driver.BaseTest;
import org.junit.jupiter.api.Test;
import pages.HomePage;

import java.time.LocalDateTime;

/**
 * Proje Java programlama dilinde yazılmalıdır.
 * Proje Maven projesi olarak yazılmalıdır.
 * Appium, JUnit ve Log4J kütüphanelerini kullanmanız gerekmektedir.
 * Projenizin GitHub üzerinden paylaşılması gerekmektedir
 * Projenizin OOP (Object Oriented Programming) prensiplerine uygun yazılması gerekmektedir.
 * Page Object Pattern kullanmanız gerekmektedir.
 * Qatar Airways uygulamasının son sürümünün cihazınıza yüklenmesi gerekmektedir
 **/

public class AppTest extends BaseTest {
    final String fromAirport="Berlin Brandenburg Airport"
            ,destAirport="Istanbul Airport";
    final LocalDateTime flightDate=LocalDateTime.now().plusDays(7);
    @Test
    public void test(){

        new HomePage().allowNotifications(false).allowLocationServices(false)
                .skipWelcomePage().allowOffersNotifications(false).checkIsHomePageVisible()
                .navigateToBookTab().checkBookTabIsDisplaying().selectBookingType(false)
                .clickFromAirport().selectFromAirport(fromAirport).clickDestinationAirport()
                .selectDestinationAirport(destAirport).clickToDate().selectDate(flightDate)
                .clickConfirm().clickSearchFlights().checkSelectDeparturePageIsVisible().selectDeparture()
                .selectFare().checkDepartureTime();
    }
}
