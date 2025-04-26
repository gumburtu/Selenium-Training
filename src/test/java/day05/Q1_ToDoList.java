package day05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1_ToDoList extends TestBase {


    //Go to http://webdriveruniversity.com/To-Do-List/index.html
    //Add todos: (Prepare breakfast, Wash the dishes, Take care of baby, Help your kid's homework, Study Selenium, Sleep)
    //Strikethrough all todos.
    //Delete all todos.
    //Assert that all todos deleted.


    @Test
    public void test01() throws InterruptedException {

        //Go to http://webdriveruniversity.com/To-Do-List/index.html

        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");


        //Add todos: (Prepare breakfast, Wash the dishes, Take care of baby, Help your kid's homework, Study Selenium, Sleep)

        WebElement addNew = driver.findElement(By.xpath("//input[@type='text']"));

        // 1. YOL TEK TEK SEND KEYS YOLLAYARAK TO DO LIST OLUSTURABILIRSIN
        // AMA BU IYI BIR YONTEM DEGIL

//       addNew.sendKeys("Prepare breakfast");
//       addNew.sendKeys("Wash the dishes");
//       addNew.sendKeys("Take care of baby");
//       addNew.sendKeys("Help your kid's homework");
//       addNew.sendKeys("Study Selenium");
//       addNew.sendKeys("Sleep");

        //Yukarida ki kod kismini tek tek yazmaya gerek yok cunku code kalabaligi olmus olacak bunun yerine. List kullanabiliriz....
        //Iyi practice icin ve temiz kod icin her zaman alternatif yollari dusunmeliyiz...

        //Eklenecek gorevleri list halinde hazirladim. Clean code icin ve hizlilik icin..

        List<String> toDoList = new ArrayList<>(Arrays.asList("Prepare breakfast", "Wash the dishes",
                "Take care of baby",
                "Help your kid's homework",
                "Study Selenium", "Sleep"));


        // for each loop olusturdum cunku elementi tek tek gondersin hizli bir sekilde....
        for (String w : toDoList) {
            addNew.sendKeys(w + Keys.ENTER);  // Keys enteri eklememizi  sebebi manual test yaparken enter tusuna tiklamamiz.....
//           Thread.sleep(3000);
        }


        //Strikethrough all todos. Butun gorevleri isaretle yapildi olarak....

        //Hepsini isaretlicegim icin ben bunlari bir locatiri bir listenin icine atabilirim.

//        driver.findElement(By.xpath("//li")).click();
//        driver.findElement(By.xpath("//li")).click();
//        driver.findElement(By.xpath("//li")).click();
//        driver.findElement(By.xpath("//li")).click();
//        driver.findElement(By.xpath("//li")).click();
//        driver.findElement(By.xpath("//li")).click();

        List<WebElement> toStrikeThrough = driver.findElements(By.xpath("//li"));


        //for each loop kullaniyoruz burda elemente sirasiyla tiklamak/strike yapmak icin

        for (WebElement w : toStrikeThrough) {
            w.click();
        }

        //Lambda methodu da kullanilabilir for each loop yerine...


        //toStrikeThrough.forEach(WebElement::click);


        //Delete all todos.

        //hepsini silecegimiz icin cop kutularinin locatirini bir listenin icine aldim...

        List<WebElement> copKutusu = driver.findElements(By.xpath("//i[@class='fa fa-trash']"));


        //Tek tek tiklama
        for (WebElement w : copKutusu) {
            w.click();
            Thread.sleep(1000);
        }

        //Lambda kullanilabilir alternatif olarak

        //copKutusu.forEach(WebElement::click);


        //Assert that all todos deleted. //Bos oldugunu verify et...

        List<WebElement> sildiktenSonraList = driver.findElements(By.xpath("//li"));

        System.out.println(sildiktenSonraList.size());


        Assertions.assertTrue(sildiktenSonraList.isEmpty());

    }
}