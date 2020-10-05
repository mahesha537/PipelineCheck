package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class check1Steps {
    WebDriver driver;
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\Webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    @Given("the user opens Google Webiste")
    public void the_user_opens_Google_Webiste() {
        driver.get("https://www.google.com/");
    }

    @When("User enters search Keyword")
    public void user_enters_search_Keyword() {
        WebDriverWait wait= new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//img[contains(@alt,'Google')]"))));
        driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Hello");
    }

    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
        // Write code here that turns the phrase above into concrete actions
        // driver.findElement(By.xpath("(//input[@value='Google Search'])[2]")).click();
        driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(Keys.ENTER);
    }



    @Then("User gets the search results")
    public void user_gets_the_search_results() {
        WebDriverWait wait= new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.titleIs("Hello - Google Search"));
    }

    @After
    public void terminate(){
        driver.quit();
    }
}
