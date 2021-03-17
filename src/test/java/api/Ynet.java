package api;

import static io.restassured.RestAssured.*; // static 
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.CoreMatchers.*;

public class Ynet extends BaseTest {
	
	@Story("check status code")
	@Test(description = "GET YNET return 200", enabled = true)
	public void StatusCode200makofood() throws InterruptedException {

		String body = when()
				.get("https://www.mako.co.il/food?partner=NavBar")
				.asString();
		System.out.println(body);
		
	}
	
	@Story("check status code")
	@Test(description = "GET YNET return 200", enabled = false)
	public void StatusCode200mako() throws InterruptedException {

		{
			given()
			.log()
			.all()
			.when()
			.get("https://www.mako.co.il/food?partner=NavBar")
			.then().body("content", equalTo("אוכל טוב"));
			

		}
	}

	@Story("check status code")
	@Test(description = "GET YNET return 200", enabled = false)
	public void StatusCode200Ynet() throws InterruptedException {

		{
			given()
			.log()
			.all()
			.when()
			.get("home/0,7340,L-8,00.html")
			.then()
			.statusCode(200);

		}
	}
	
	@Story("check if Validation Fails get log in the console /200 fassed no log /400 fails send log")
	@Test(description = "GET YNET return 200", enabled = false)
	public void StatusCode200Yneta() throws InterruptedException {

		{
			given()
			.log()
			.ifValidationFails()
			.when()
			.get("home/0,7340,L-8,00.html")
			.then()
			.statusCode(200);

		}
	}

	@Test(description = "GET does not return Forbiden", enabled = false)
	public void StatusCodeIsNot403() throws InterruptedException {

		{
			RequestSpecification httpRequest = RestAssured.given();
			Response response = httpRequest.get("home/0,7340,L-8,00.html1");
			if (response.getStatusCode() == 400) {

			}
			Assert.assertNotEquals(403, response.getStatusCode(), "Test Failed Response is" + response.getStatusCode());

		}

	}

	// this meted check if the status code is 400 then is open Ynet. the status code
	// for the response is 200 open walla.
	@Test(description = "GET does not return Forbiden", enabled = false)
	public void StatusCodeIsNot403_02() throws InterruptedException {

		{
			RequestSpecification httpRequest = RestAssured.given();
			Response response = httpRequest.get("home/0,7340,L-8,00.html1");
			if (response.getStatusCode() == 400) {
				ChromeDriver driver = new ChromeDriver();
				driver.navigate().to("https://www.walla.co.il");
			} else {
				ChromeDriver driver = new ChromeDriver();
				driver.navigate().to("https://www.ynet.co.il");
			}
			Assert.assertNotEquals(403, response.getStatusCode(), "Test Failed Response is" + response.getStatusCode());

		}

	}
	
	@Test(description = "GET ", enabled = false)
	public void apiYesNo_03() throws InterruptedException {
		{
		when().get("https://yesno.wtf/api").then().body("answer", equalTo("no"));
		}//import static org.hamcrest.CoreMatchers.*;
	}
	
	

}
