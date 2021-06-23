import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class google {

    static WebDriver driver;
    public String googleurl = "https://www.google.se/";
    static String LoginHeader;
    static String DisplayName;
    static String AgreementPartnerHP;

    WebElement element;
    WebDriverWait wait;


    @BeforeTest
    public void setup() throws Exception {
        driver = new HandelDriver().getDriver("CHROME");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    //To verify the Title on the webpage
    @Test(priority = 1)
    public void VerifyLoginPageTitle() throws InterruptedException {
        driver.get(googleurl);

        //Wait
        Thread.sleep(2000);

        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }


    @AfterTest
    public void afterTest() {
        driver.close();
    }

}