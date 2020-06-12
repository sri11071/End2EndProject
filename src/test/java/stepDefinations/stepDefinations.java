package stepDefinations;

import org.openqa.selenium.chrome.ChromeDriver;

import com.wavelabs.BaseTest;
import com.wavelabs.pageobject.HomePage;
import com.wavelabs.pageobject.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinations extends BaseTest {

	@Given("^Intialize Driver $")
	public void intialize_driver() throws Throwable {
		String dir = System.getProperty("user.dir");
		String driverpath = dir + "\\src\\test\\resources\\drivers";
		System.setProperty("webdriver.chrome.driver", driverpath + "\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Given("^Open application \"([^\"]*)\" url $")
	public void open_application_something_url(String strArg1) throws Throwable {
		driver.get(strArg1);
	}

	@Given("^close popup and click login link $")
	public void close_popup_and_click_login_link() throws Throwable {
		HomePage hp = new HomePage(driver, wait);
		if (hp.getPopUpElements().size() > 0) {
			hp.getPopUp().click();
		}
		hp.LoginClick();
	}

	@When("^User entered (.+) and password (.+) and login $")
	public void user_entered_and_password_and_login(String username, String password) throws Throwable {
		LoginPage lp = new LoginPage(driver, wait);
		lp.getEmailId().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getLoginButton().click();
	}

	@Then("^User redirects to portal Login page 	$")
	public void user_redirects_to_portal_login_page() throws Throwable {
		log.info(driver.getCurrentUrl());
	}

}