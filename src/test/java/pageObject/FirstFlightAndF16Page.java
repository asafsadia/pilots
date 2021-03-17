package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FirstFlightAndF16Page extends BasePage{
    @FindBy(css = ".ui-datepicker-month")
    private WebElement eMonth;
    @FindBy(css = ".ui-datepicker-year")
    private WebElement eYear;
    @FindBy(css = "")
    private WebElement eDay;
    @FindBy(css = ".ui-datepicker-next.ui-corner-all")
    private WebElement nextBtn;
    @FindBy(css = ".ui-state-default")
    private WebElement Aday;

    public FirstFlightAndF16Page(WebDriver driver) {
        super(driver);
    }

    public void chooseDate(String month, String year, String day){
        while ( (! month.equals(eMonth)) || (! year.equals(eYear))){
            click(nextBtn);
        }
//        List<WebElement> day = driver.findElements(By.cssSelector(".ui-state-default"));
//        for(WebElement el :day){
//            if(el.getText().equals(day)){
//               click(el);
//               break;
//            }
        }

//        public void chooseDay(String day){
//            for(WebElement el :day){
//            if(el.getText().equals(day)){
//               click(el);
//               break;
//            }
//        }
//     }


    public String getMonth(){
        return getText(eMonth);
    }

    public String getYear(){
        return getText(eYear);
    }

}
