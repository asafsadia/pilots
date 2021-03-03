package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class WelcomePage extends BasePage{
	
	@FindBy(css = "body > div.elementor.elementor-15 > div > div > section.elementor-section.elementor-top-section.elementor-element.elementor-element-363beec1.elementor-section-height-min-height.elementor-section-boxed.elementor-section-height-default.elementor-section-items-middle > div.elementor-container.elementor-column-gap-default > div > div > div > div > div.elementor-element.elementor-element-18a0e122.elementor-align-center.elementor-widget.elementor-widget-button > div > div > a")
	private WebElement orderFlightBtn;
	@FindBy(css = "#menu-1-dad5fc1 > li.menu-item.wpml-ls-slot-24.wpml-ls-item.wpml-ls-item-en.wpml-ls-menu-item.wpml-ls-first-item.wpml-ls-last-item.menu-item-type-wpml_ls_menu_item.menu-item-object-wpml_ls_menu_item.menu-item-wpml-ls-24-en > a")
	private WebElement english;
	@FindBy(css = ".elementor-column.elementor-col-16.elementor-top-column.elementor-element.elementor-element-286a487e.flexpanel")
	private WebElement ShopBtn;
	@FindBy(css = "#menu-2-70005c2c")
	private WebElement muneShop;

	public WelcomePage(WebDriver driver) {
		super(driver);
	}
	
	@Step("selecting item {name}  from list on the home page")
	public void chooseItem(String name) {
//		js.executeScript("window.scrollBy(0,700)");
		List<WebElement> list = driver.findElements(By.cssSelector("#menu-2-70005c2c > li.menu-item.menu-item-type-custom.menu-item-object-custom.menu-item-1533"));
		for (WebElement el : list) {
			if (getText(el).equalsIgnoreCase(name)) {
				click(el);

				break;
			}
		}
	}
	
	
	public void clickOnShop() {
		moveTo(ShopBtn);
		sleep(5000);
		click(ShopBtn);
		
	}
	
	@Story("get the color from element return RGB")
	public void getLogoColor() {
		WebElement eleSearch = driver.findElement(By.cssSelector(".elementor-element-3440071e.elementor-section-boxed.elementor-section-height-default.elementor-section-height-default > div > div > div > div > div > div > div > h2"));

		String rgbFormat = eleSearch.getCssValue("color");

		System.out.println(rgbFormat);     //In RGB Format the value will be print => rgba(254, 189, 105, 1)

		String hexcolor = Color.fromString(rgbFormat).asHex(); //converted Into HexFormat
		System.out.println(hexcolor);// Output of Hex code will be  => #164b80
	}

	public void goToEnglish(){
		click(english);

	}
	
	public void orderFlight() {
		click(orderFlightBtn);
		
	}
	

}
