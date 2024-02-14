package stepdefinitions;



import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	
	private static String title;
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());

	@Given("user is on login page")
	public void user_is_on_login_page() {

		DriverFactory.getDriver().get("https:www.google.com");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {

		 title = loginpage.getLoginPageTitle();
		System.out.println("Page Title is : " + title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
		Assert.assertTrue(title.contains(expectedTitleName));
	}

}
