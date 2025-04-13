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

public class Q04_Calculator {

//    • Create chrome driver by using @BeforeEach annotation and WebDriverManager
//• Navigate to https://testpages.herokuapp.com/styled/index.html
//            • Click on Calculator under Micro Apps
//• Type any number in the first input
//• Type any number in the second input
//• Click on Calculate
//• Get the result
//• Verify the result
//• Print the result
//• Close the browser by using @AfterEach annotation


//
//    • Create chrome driver by using @BeforeEach annotation and WebDriverManager

    WebDriver driver;

    @BeforeEach
    public void setUp() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test
    public void test01() {


//• Navigate to https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");

//• Click on Calculator under Micro Apps
        WebElement calculatorTitle = driver.findElement(By.id("calculatetest"));
        calculatorTitle.click();


        //kullanicinin calculator sayfasinda oldugunu dogrula

        String actualResult = driver.getTitle();

        Assertions.assertTrue(actualResult.contains("Calculator"));

//• Type any number in the first input
        Faker faker = new Faker();

        WebElement firstInput = driver.findElement(By.id("number1"));


        String firstNumber = faker.number().digit();


        firstInput.sendKeys(firstNumber);


//• Type any number in the second input

        WebElement secondInput = driver.findElement(By.id("number2"));


        String secondNumber = faker.number().digit();
        secondInput.sendKeys(secondNumber);

//• Click on Calculate

        WebElement calculate = driver.findElement(By.id("calculate"));

        calculate.click();
//• Get the result
        WebElement answer = driver.findElement(By.id("answer"));


        String actualAnswer = answer.getText();

//• Verify the result

        int first = Integer.parseInt(firstNumber);  // First numberi string oldugundan dolayi int e cevirdik
        int second = Integer.parseInt(secondNumber);
        int toplam = first + second;    //int cevirelen degerleri topladik

        int actual = Integer.parseInt(actualAnswer); //actual answer string oldugundan int degere cevirdik

        Assertions.assertEquals(toplam, actual);

//• Print the result

        System.out.println("toplam = " + toplam);
        System.out.println("actual = " + actual);


    }

    //• Close the browser by using @AfterEach annotation
    @AfterEach
    public void tearDown() throws InterruptedException {

        Thread.sleep(3000);
        driver.quit();
    }

}