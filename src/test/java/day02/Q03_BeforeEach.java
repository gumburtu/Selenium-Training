package day02;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q03_BeforeEach {


    //• Create chrome driver by using @BeforeEach annotation and WebDriverManager
    //• Go to url : http://www.gmibank.com/
    //• Click on 'User Icon'
    //• Click on 'Register'
    //• Enter SSN
    //• Enter First Name
    //• Enter Last Name
    //• Enter Address
    //• Enter Phone Number
    //• Enter Username
    //• Enter Email
    //• Enter New password
    //• Enter New password confirmation
    //• Click on Register button
    //• Assert that user registered
    //• Close the browser by using @AfterEach annotation


    WebDriver driver;
    //• Create chrome driver by using @BeforeEach annotation and WebDriverManager

    @BeforeEach
    public void setUp() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test
    public void test() {


        //• Go to url : http://www.gmibank.com/
        driver.get("http://www.gmibank.com/");

        //• Click on 'User Icon'
        WebElement userIcon = driver.findElement(By.id("account-menu"));
        userIcon.click();
        //• Click on 'Register'

        WebElement registerOption = driver.findElement(By.linkText("Register"));

//       WebElement registerOption = driver.findElement(By.partialLinkText("Regi"));
        registerOption.click();


        // kullanici register sayfasinda oldugunu dogrular

        String actualResult = driver.getCurrentUrl();

        Assertions.assertTrue(actualResult.contains("register"));

        //• Enter SSN
        WebElement ssn = driver.findElement(By.id("ssn"));

        ssn.sendKeys("123456784");

        //• Enter First Name

        WebElement firstName = driver.findElement(By.name("firstname"));

        firstName.sendKeys("Harry");
        //• Enter Last Name

        WebElement lastname = driver.findElement(By.name(("lastname")));

        lastname.sendKeys("Whitee");
        //• Enter Address

        WebElement address = driver.findElement(By.name("address"));

        address.sendKeys("Street 19 LA2");

        //• Enter Phone Number

        WebElement phoneNumber = driver.findElement(By.xpath("//input[@id='mobilephone']"));

        phoneNumber.sendKeys("5580344444");

        //• Enter Username

        WebElement userName = driver.findElement(By.name("username"));

        userName.sendKeys("BreakingBaad");

        //• Enter Email

        WebElement mail = driver.findElement(By.name("email"));

        mail.sendKeys("breakingbad0122@mail.com");
        //• Enter New password

        WebElement password = driver.findElement(By.name("firstPassword"));

        password.sendKeys("Batch3072!");

        //• Enter New password confirmation

        WebElement confirmPass = driver.findElement(By.name("secondPassword"));

        confirmPass.sendKeys("Batch3072!");

        //• Click on Register button

        WebElement registerButton = driver.findElement(By.id("register-submit"));

        registerButton.click();
        //• Assert that user registered

        WebElement successRegister = driver.findElement(By.xpath("(//div[@role='alert'])[1]"));


        //Assertions.assertTrue(successRegister.getText().contains("Registration saved"));

        Assertions.assertTrue(successRegister.isDisplayed());

        //• Close the browser by using @AfterEach annotation
    }

    @AfterEach
    public void tearDown() throws InterruptedException {

        Thread.sleep(3000);
        driver.quit();
    }
}