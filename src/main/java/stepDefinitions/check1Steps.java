package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class check1Steps {
    WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Webdriver\\chromedriver.exe");
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
        WebDriverWait wait = new WebDriverWait(driver, 60);
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
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.titleIs("Hello - Google Search"));
    }

    @After
    public void terminate() {
        driver.quit();
    }

    @When("User enters new search Keyword")
    public void userEntersNewSearchKeyword() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//img[contains(@alt,'Google')]"))));
        driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Hi");
    }

    @Then("User gets the new search results")
    public void userGetsTheNewSearchResults() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.titleIs("Hi - Google Search"));
        WebElement element = driver.findElement(By.xpath("//input[@name='q' and @type='text']"));
        keyStroke(Keys.PAGE_DOWN);
        element.clear();
        element.sendKeys("Hello");
        Thread.sleep(2000);
        keyStroke(Keys.ENTER);
        Thread.sleep(9000);
        keyStroke(Keys.PAGE_DOWN);
        Actions act = new Actions(driver);
        act.keyDown(Keys.CONTROL).click(driver.findElement(By.xpath("//span[contains(text(),'Wikipedia')]"))).keyUp(Keys.CONTROL).build().perform();
        driver.findElement(By.xpath("//input[@title='Search']")).clear();
        driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Hi wiki");
        act.keyDown(Keys.CONTROL).click(driver.findElement(By.xpath("//span[contains(text(),'HI - Wikipedia')]"))).keyUp(Keys.CONTROL).build().perform();
        driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(Keys.ENTER);
        switchToWindow("Hello (Adele song) - Wikipedia");
        System.out.println("Succesfully switched to the new window");
        Thread.sleep(4000);
        keyStroke(Keys.PAGE_DOWN);
        keyStroke(Keys.PAGE_DOWN);
        Thread.sleep(3000);
        switchToWindow("HI - Wikipedia");
        System.out.println("Succesfully switched to the new window");
        Thread.sleep(4000);
        keyStroke(Keys.PAGE_DOWN);
        keyStroke(Keys.PAGE_DOWN);
        Thread.sleep(10000);



    }

    public void keyStroke(Keys keyToPress) throws InterruptedException {
        Actions act = new Actions(driver);
        act.sendKeys(keyToPress).build().perform();
        Thread.sleep(3000);
    }

    public void switchToWindow(String name){
        int flag=0;
        try{
            ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
            if(windows.size()>0) {
                System.out.println("windows size: "+windows.size());
                for(int i=0;i<windows.size();i++){
                    String Title = driver.switchTo().window(windows.get(i)).getTitle();
                    if(Title.equalsIgnoreCase(name)){
                        flag=1;
                        driver.switchTo().window(windows.get(i));
                        break;
                    }else{
                        flag=0;
                    }
                }if(flag==0){
                    Assert.fail("window '"+name+"' is not found. Possibly window title passed is wrong");
                }
            }else{
                Assert.fail("No Window is opened");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

//    public void keyStroke(String keyToPress) throws InterruptedException {
//    }
//        Actions act = new Actions(driver);
//
//        act.sendKeys(key).build().perform();
//        Thread.sleep(3000);
//}
