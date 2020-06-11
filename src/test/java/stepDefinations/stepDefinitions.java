package stepDefinations;

import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;

import com.wavelabs.BaseTest;
import com.wavelabs.pageobject.HomePage;
import com.wavelabs.pageobject.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class stepDefinitions extends BaseTest {

	@Given("Intialize Driver")
	public void intialize_Driver() {
		String dir = System.getProperty("user.dir");
		String driverpath = dir + "\\src\\test\\resources\\drivers";
		System.setProperty("webdriver.chrome.driver", driverpath + "\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Given("Open application {string} url")
	public void open_application_url(String string) {
		driver.get(string);
		
	}

	@Given("close popup and click login link")
	public void close_popup_and_click_login_link() {
	    // Write code here that turns the phrase above into concrete actions
		HomePage hp = new HomePage(driver, wait);
		if(hp.getPopUpSize().size()>0) {
			hp.getPopUp().click();
		}
		hp.LoginClick();
		
	}

	@When("User entered {string} and password {string} and login")
	public void user_entered_and_password_and_login(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
		LoginPage lp =new LoginPage(driver, wait);
		lp.getEmailId().sendKeys(string);
		lp.getPassword().sendKeys(string2);
		lp.getLoginButton().click();
	}

	@Then("User redirects to portal Login page")
	public void user_redirects_to_portal_Login_page() {
	    // Write code here that turns the phrase above into concrete actions
		log.info(driver.getCurrentUrl());
	}



}