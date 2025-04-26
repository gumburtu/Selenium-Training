package day05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Q2_WebTableAmount extends TestBase {


    //Go to https://testpages.herokuapp.com/styled/tag/table.html
    //
    //Calculate the total amount on the table
    //
    //Assert the amount


    @Test
    public void Test02() {


        //Go to https://testpages.herokuapp.com/styled/tag/table.html

        driver.get("https://testpages.herokuapp.com/styled/tag/table.html");

        //Uzun yol; tek tek locatorlari alip toplama islemi yapabilirim, TAVSIYE EDILMEZ

        ////tr[2]//td[2],  //tr[3]//td[2], //tr[3]//td[2]

        //tablodaki amount degerleri row>data iliskisi oldugundan dolayi, tek bir locator alip bunu bir listeye atabilirim. Kisa yolu budur.


        List<WebElement> amount = driver.findElements(By.xpath("//tr//td[2]"));

        //Calculate the total amount on the table

        double sum = 0;
        for (WebElement w : amount) {

            String amountStr = w.getText();

            //System.out.println("amountStr = " + amountStr);

            sum += Double.parseDouble(amountStr);

            System.out.println("sum = " + sum);

        }


        // Assert the amount

        Assertions.assertEquals(110.3, sum);

    }
}