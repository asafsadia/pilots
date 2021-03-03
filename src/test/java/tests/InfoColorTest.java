package tests;

import org.testng.annotations.Test;

import pageObject.WelcomePage;

public class InfoColorTest extends BaseTest{
	
	@Test
	public void logoColor() {

		WelcomePage wp = new WelcomePage(driver);
//		wp.getLogoColor();
		wp.goToEnglish();
		wp.clickOnShop();
		wp.sleep(2000);
		wp.chooseItem("accessories");
		
	}

}
