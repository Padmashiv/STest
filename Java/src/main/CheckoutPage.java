
package localpage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.net.URL;

public class CheckoutPage {
    private final WebDriver driver;
    private final String url = "https://getbootstrap.com/docs/5.0/examples/checkout/";

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    protected CheckoutPageElements elements() {
        return new CheckoutPageElements(driver);
    }

    public CheckoutPageAssertions assertions() {
        return new CheckoutPageAssertions(driver);
    }

    public void navigate() {
        driver.navigate().to(url);
    }

    public void fillInfo(ClientInfo clientInfo) {
        elements().firstName().sendKeys(clientInfo.getFirstName());
        elements().lastName().sendKeys(clientInfo.getLastName());
        elements().username().sendKeys(clientInfo.getUsername());
        elements().email().sendKeys(clientInfo.getEmail());
        elements().address1().sendKeys(clientInfo.getAddress1());
        elements().address2().sendKeys(clientInfo.getAddress2());
        elements().country().selectByIndex(clientInfo.getCountry());
        elements().state().selectByIndex(clientInfo.getState());
        elements().zip().sendKeys(clientInfo.getZip());
        elements().cardName().sendKeys(clientInfo.getCardName());
        elements().cardNumber().sendKeys(clientInfo.getCardNumber());
        elements().cardExpiration().sendKeys(clientInfo.getCardExpiration());
        elements().cardCVV().sendKeys(clientInfo.getCardCVV());

        var js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", elements().submitButton());
    }
}
