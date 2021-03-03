package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightBookingPage extends BasePage{
    @FindBy(css = "#\\31  > div > div > div > div > div > figure > a > img")
    private WebElement firstVisit;
    @FindBy(css = "#post-3534 > div > div > section > div > div > div > div > div > div.elementor-element.elementor-element-d50c277.elementor-align-center.type1.elementor-widget.elementor-widget-button > div > div > a > span > span.elementor-button-text")
    private WebElement firstFlightAndF16;
    @FindBy(css = ".elementor-widget-heading > div > h1")
    private WebElement title;

    public FlightBookingPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle(){
       return getText(title);
    }

    @Step("select first visit")
    public void choosFirstVisit(){
        click(firstVisit);
        click(firstFlightAndF16);

    }

}
