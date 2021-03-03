package api;

import static io.restassured.RestAssured.*; // static 
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.net.URL;
import java.sql.Driver;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.CoreMatchers.*;

public class Ynet extends BaseTest {

	@Test(description = "GET YNET return 200", enabled = true)
	public void StatusCode200Ynet() throws InterruptedException {

		{
			given().log().all().when().get("home/0,7340,L-8,00.html").then().statusCode(200);
			given().log().ifValidationFails().when().get("home/0,7340,L-8,00.html").then().statusCode(200);

		}
	}

	@Test(description = "GET does not return Forbiden", enabled = false)// test
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
