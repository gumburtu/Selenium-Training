package day03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Q3_MatchCaptcha extends TestBase {

    //• Go to https://form.jotform.com/73302671092956
    //• Click on start
    //• Enter firstname and lastname
    //• Click on next
    //• Enter email
    //• Click on next
    //• Enter message
    //• Click on next
    //• Handle captcha
    //• Click on submit
    //• Assert that submission is received


    @Test
    public void test01() {

        //• Go to https://form.jotform.com/73302671092956

        driver.get("https://form.jotform.com/73302671092956");


        //• Click on start

        WebElement startButton = driver.findElement(By.id("jfCard-welcome-start"));

        startButton.click();


        //• Enter firstname and lastname

        WebElement first_name = driver.findElement(By.id("first_1"));

        first_name.sendKeys("Walter");

        WebElement last_name = driver.findElement(By.id("last_1"));

        last_name.sendKeys("White");

        // Click to the Next Button

        WebElement nextButton = driver.findElement(By.xpath("//button[@data-testid='nextButton_0']"));

        nextButton.click();

        //• Enter email

        WebElement email = driver.findElement(By.id("input_2"));

        email.sendKeys("breakingbad@mail.com");

        //• Click on next

        WebElement nextEmailButton = driver.findElement(By.xpath("//button[@data-testid='nextButton_1']"));

        nextEmailButton.click();


        //Send a message into the message box


        WebElement messageBox = driver.findElement(By.id("input_3"));

        messageBox.sendKeys("Breaking bad is the best series");

        // Click on the next button

        WebElement nextMessageButton = driver.findElement(By.xpath("//button[@data-testid='nextButton_2']"));

        nextMessageButton.click();


        //Burda bir captcha var ve bu captchaya ulasmak icinde iframe olarak gecis yapmam lazim


        //Caotcha bir iframe icinden oldugundan dolayi ilk once bizim iframe i gecmemiz sonra 4 islemi yapmamiz gerekiyor....

        driver.switchTo().frame(0);

        String ilkNumara = driver.findElement(By.id("number")).getText();
        int firstNumber = Integer.parseInt(ilkNumara);
        String ikinciNumara = driver.findElement(By.id("number2")).getText();

        int secondNumber = Integer.parseInt(ikinciNumara);

        String operator = driver.findElement(By.id("function")).getText();

        int sonuc;

        if (operator.contains("+")) {

            sonuc = firstNumber + secondNumber;
        } else if (operator.contains("-")) {

            sonuc = firstNumber - secondNumber;
        } else if (operator.contains("/")) {

            sonuc = firstNumber / secondNumber;

        } else {

            sonuc = firstNumber * secondNumber;
        }


        //result kismina 4 islemin sonucunu ekle


        WebElement resultBox = driver.findElement(By.id("result"));

        resultBox.sendKeys(sonuc + "");


        driver.switchTo().defaultContent();
//        driver.switchTo().parentFrame();


        //submit buttonuna tikla

        WebElement submit = driver.findElement(By.xpath("(//button[@data-testid='submitButton'])[4]"));

        submit.click();

        //Assert et

        WebElement thanksText = driver.findElement(By.xpath("//h1"));

        Assertions.assertTrue(thanksText.getText().contains("Thank"));

    }
}