package day03;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Q1_AddRemoveButton {
    //
//
//
//    • Given
//• Go to http://the-internet.herokuapp.com/add_remove_elements/
//            • When
//• Click on the "Add Element" button 100 times
//• And
//• Click on the "Delete" button 20 times
//• Then
//• Assert that 20 buttons were deleted.
    WebDriver driver;

    @BeforeEach
    public void setUp(){

        // driver objesini olustur webdriver classindan
        driver = new ChromeDriver();

        //windows u maximize yap her zaman ....
        driver.manage().window().maximize();

        // ayni url her testte kullanacagimizi farz edelim. Boyle bir durum da driver.get(); methodunu beforeEacj icine ekliyorum....

        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        //sayfanin yuklenmesi icin driveri biraz bekletmemiz gerekiyor.....

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }


    @Test
    public void test01(){


//        • When Click on the "Add Element" button 100 times

        WebElement addButton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));

        for(int i=0; i<100; i++){

            addButton.click();

        }


        //• And
//• Click on the "Delete" button 20 times


        //Alttaki webelement tek bir web elementi dondurecegi icin fazla kod gereksimiyle testimizi tamamlamis oluruz...
//        WebElement deleteButton = driver.findElement(By.xpath("//button[@class='added-manually']"));

        // findElements(); methodunu kullanirim cunku butun delete buttonlarini bir listeye alirim....

        List<WebElement> deleteButton = driver.findElements(By.xpath("//button[@class='added-manually']"));

//        System.out.println(deleteButton.size()); 100

        for(int i=0; i<20; i++){

            deleteButton.get(i).click();

        }


        //• Assert that 20 buttons were deleted.


        List<WebElement> afterDeleteButtons = driver.findElements(By.xpath("//button[@class='added-manually']"));

//        System.out.println("afterDeleteButtons.size() = " + afterDeleteButtons.size ()); 80

        Assertions.assertEquals(deleteButton.size()-20,afterDeleteButtons.size());

    }

    @AfterEach
    public void tearDown() throws InterruptedException {

        Thread.sleep(3000);

        driver.quit();
    }

}