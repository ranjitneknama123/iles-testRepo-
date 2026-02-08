package stepdefinitions;

import com.ranjit.harmony.utils.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Data;
import io.cucumber.java.it.Ma;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;

import java.util.List;
import java.util.Map;

public class LoginSteps {

    WebDriver driver;
    LoginPage loginPage;

    @Given("user is on login page")
    public void user_is_on_login_page() {
        driver = DriverFactory.getDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @When("user enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("clicks login button")
    public void clicks_on_login_button() {
        loginPage.clickLogin();
    }

    @Then("user should see dashboard")
    public void user_should_be_navigated_to_home_page() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory"));
    }

    @When("I search the following items and validate results")
    public void I_search_the_following_items_and_validate_results(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            loginPage.enterUsername(row.get("items"));
            Thread.sleep(200);
            loginPage.enterPassword(row.get("items"));
            Thread.sleep(200);
        }

    }

    @When("pass single parameter test")
    public void pass_single_parameter_test(DataTable dataTable) {
        List<String> rows = dataTable.asList(String.class);
        for (String row : rows) {
            System.out.println(row);
        }
    }

    @When("I enter username and password into text field")
    public void i_enter_username_and_password_into_text_field(DataTable dataTable) {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> rows : data) {
            System.out.printf(rows.get("username"));
            System.out.printf(rows.get("password"));
        }
    }

    @When("I on login page sign up form {string}")
    public void I_on_login_page_sign_up_form_signup(String signUp) {
        System.out.println(signUp);
    }

    @When("i am on the login page enter username as {string} and password as {string}")
    public void i_am_on_the_login_page_enter_username_as_and_password_as(String username, String password) {
        System.out.println(username);
        System.out.println(password);
    }

    @When("user is not exisrting sign up form")
    public void user_is_not_exisrting_sign_up_form(DataTable dataTable) {
        List<String> allRows = dataTable.asList(String.class);
        for (String row : allRows) {
            System.out.println(row);
        }

    }

    @When("user enter multiple column data")
    public void user_enter_multiple_column_data(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            System.out.println(row.get("userNameHeader"));
            System.out.println(row.get("passwordHeader"));
        }
    }

    @When("enter username as {string} and password as {string} into text field check {string}")
    public void enter_username_as_userName_and_password_as_password_into_text_field_check_message(String user, String password, String message) {
        System.out.println(user);
        System.out.println(password);
    }

    @Then("validate message as {string}")
    public void valida_message_as_Successfully(String message) {
        System.out.println(message);
    }


}

