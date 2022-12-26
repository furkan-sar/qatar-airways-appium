package pages;

import methods.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class HomePage {
    private final Method method = new Method();
    private final Logger logger = LogManager.getLogger(HomePage.class);

    public HomePage allowNotifications(boolean permission) {
        /** SECENEGIN EKRANDA GORUNMESI CEREZLERE BAGLI OLARAK DEGISMEKTEDIR **/
        logger.info("BILDIRIM SECENEGI BEKLENIYOR...!!!");
        try{
            if (permission) {
                method.click(By.id("com.android.permissioncontroller:id/permission_allow_button"));
                logger.info("Bildirimlere izin verildi.");
            } else {
                method.click(By.id("com.android.permissioncontroller:id/permission_deny_button"));
                logger.info("Bildirimlere izin verilmedi.");
            }
        }catch (Exception e){
            logger.info("Uygulama tarafindan bildirim secenegi sunulmadi.");
        }
        return new HomePage();
    }

    public HomePage allowLocationServices(boolean permission) {
        try {
            if (permission) {
                method.click(By.id("com.m.qr:id/enable_location_button"));
                logger.info("Konum hizmetlerine izin verildi.");
            } else {
                method.click(By.id("com.m.qr:id/skip_button"));
                logger.info("Konum hizmetlerine izin verilmedi.");
            }
        }catch (Exception e){
            logger.info("Uygulama tarafindan konum hizmetleri secenegi sunulmadi.");
        }
        return new HomePage();
    }

    public HomePage allowOffersNotifications(boolean permission) {
        try {
            if (permission) {
                method.click(By.id("com.m.qr:id/push_consent_allow"));
                logger.info("Bildirimlere izin verildi.");
            } else {
                method.click(By.id("com.m.qr:id/push_consent_decline"));
                logger.info("Bildirimlere izin verilmedi.");
            }
        }catch (Exception e){
            logger.info("Uygulama tarafindan teklif bildirimleri secenegi sunulmadi.");
        }
        return new HomePage();

    }

    public HomePage skipWelcomePage() {
        method.click(By.id("com.m.qr:id/onboarding_skip_button"));
        logger.info("Karsilama ekrani skip secenegi ile gecildi.");
        return new HomePage();
    }

    public HomePage checkIsHomePageVisible() {
        Assertions.assertTrue(method.findElement(By.id("com.m.qr:id/nav_menu_home")).isSelected(), "Anasayfa'ya yonlendirilemedi");
        logger.info("Anasayfa'ya yonlendirildi");
        return new HomePage();
    }

    public BookPage navigateToBookTab() {
        method.click(By.id("com.m.qr:id/nav_menu_book"));
        return new BookPage();
    }


}