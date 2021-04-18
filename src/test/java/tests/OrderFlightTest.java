package tests;

import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.FirstFlightPage;
import pageObject.FlightBookingPage;
import pageObject.WelcomePage;

public class OrderFlightTest extends BaseTest{

	@Step("select english")
	@Test(priority = 1)
	public void english(){
		WelcomePage wp = new WelcomePage(driver);
		wp.goToEnglish();
	}

	@Step("order flight")
	@Test(priority = 2)
	public void orderFlight() {
		WelcomePage wp = new WelcomePage(driver);
		wp.orderFlight();

		FlightBookingPage fbp = new FlightBookingPage(driver);
		String actual = fbp.getTitle();
		String expected = "Flight Booking";
		System.out.println("Title: " + actual);
		Assert.assertEquals(actual, expected);
//		fbp.choosFirstVisit();
	}

	@Step("selected date")
	@Test(priority = 3)
	public void selectDate(){
		FlightBookingPage fbp = new FlightBookingPage(driver);
		fbp.firstFlightBtn();

	}

}
