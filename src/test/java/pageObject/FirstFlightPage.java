package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FirstFlightPage extends BasePage{

    @FindBy(css = "#dp1616957497384 > div > table > tbody > tr:nth-child(5) > td.weekday-3.partial_scheduled.remaining_scheduled_7.appointable > a")
    private WebElement date31Btn;
    @FindBy(css = "#wc-appointments-appointment-form > div.form-field.form-field-wide > div > div > ul.slot_column.afternoon > li:nth-child(2) > a")
    private WebElement timeSelect;
    @FindBy(css="#wcpa-checkbox-group-1607345216973 > div > div > label > span")
    private WebElement TShirtYes;
    @FindBy(css="#number-1607344290982")
    private WebElement quantity;
    @FindBy(css="#wcpa-select-1607345331236 > div > select")
    private WebElement size;
    @FindBy(css="#wcpa-select-1607345637367 > div > select")
    private WebElement logo;
    @FindBy(className = "ui-datepicker-month")
    private WebElement getCmonth;
    @FindBy(className = "ui-datepicker-year")
    private WebElement getCYear;
    @FindBy(className = ".ui-icon.ui-icon-circle-triangle-e")
    private WebElement nextBtn;

    public FirstFlightPage(WebDriver driver) {
        super(driver);
    }

    public void chooseDate(){
        String expectedDate = "31/March/2022";
        String eMonth = expectedDate.split("-")[1];
        String eYear = expectedDate.split("-")[2];
        String eDate = expectedDate.split("-")[0];

        String cMonth = getText(getCmonth);
        String cYear = getText(getCYear);

        while ( (!cMonth.equals(eMonth)) || (!cYear.equals(eYear))){

            click(nextBtn);
            cMonth = getText(getCmonth);
            cYear = getText(getCYear);
        }


    }

    public void choosAday(){
        sleep(2000);
        click(date31Btn);
        sleep(2000);
        click(timeSelect);
    }

    public void accessoriesT_Shirt(String Q, String s, String l){
        click(TShirtYes);
        fillText(quantity, Q);
        selectByValue(size, s);
        selectByValue(logo, l);
    }



}
