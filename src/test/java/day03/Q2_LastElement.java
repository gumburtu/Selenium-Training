package day03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class Q2_LastElement extends TestBase {

    // Given
    //• Go to https://www.saucedemo.com/
    //• When
    //• Enter the username as "standard_user"
    //• And
    //• Enter the password as "secret_sauce"
    //• And
    //• Click on login button
    //• And
    //• Order products by "Price (low to high)"
    //• Then
    //• Assert that last product costs $49.99, first product costs $7.99


    @Test
    public void test01() {

        //   //• Go to https://www.saucedemo.com/

        driver.get("https://www.saucedemo.com/");


        //• Enter the username as "standard_user"

        WebElement user_name = driver.findElement(By.id("user-name"));

        user_name.sendKeys("standard_user");

        //• Enter the password as "secret_sauce"

        WebElement password = driver.findElement(By.id("password"));

        password.sendKeys("secret_sauce");


        //• Click on login button

        WebElement loginButton = driver.findElement(By.id("login-button"));

        loginButton.click();

        //Urun sayfasinda oldugunu assert et....

        Assertions.assertTrue(driver.getCurrentUrl().contains("inventory"));


        //• Order products by "Price (low to high)"

        WebElement dropDownList = driver.findElement(By.xpath("//select[@class='product_sort_container']"));

        Select select = new Select(dropDownList);
        select.selectByValue("lohi");


        //• Assert that last product costs $49.99, first product costs $7.99


        List<WebElement> inventoryList = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

        System.out.println("inventoryList.size() = " + inventoryList.size()); // liste icindeki kac tane product oldugunu  soyler....


        String ilkUrunFiyati = inventoryList.get(0).getText();
        System.out.println("ilkUrunFiyati = " + ilkUrunFiyati);
        String sonUrunFiyati = inventoryList.get(inventoryList.size() - 1).getText();
        System.out.println("sonUrunFiyati = " + sonUrunFiyati);

//        Assertions.assertTrue(ilkUrunFiyati.contains("7.99"));
//        Assertions.assertTrue(sonUrunFiyati.contains("49.99"));

        Assertions.assertEquals("$7.99", ilkUrunFiyati);
        Assertions.assertEquals("$49.99", sonUrunFiyati);
    }
}