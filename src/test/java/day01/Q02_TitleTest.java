package day01;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q02_TitleTest {


//Create chrome driver object
//Maximize the window
//Open google home page https://www.google.com/
//Wait for 3 seconds
//Go to the https://techproeducation.com/
//Get the title and URL of the page
//Check if the title contains the word "Bootcamps" print console "Title contains Bootcamps" or "Title does not contain Bootcamps”
//Check if the URL contains the word "techpro" print console "URL contains techpro" or "URL does not contain techpro”
//Then go to https://medunna.com/
//Get the title and check if it contains the word "MEDUNNA" and print "Title contains MEDUNNA" or "Title does not contain MEDUNNA”
//Navigate Back to the previous webpage
//Refresh the page
//Navigate to forward
//Wait for 3 seconds
//Close the browser


    @Test
    public void test() throws InterruptedException {



//        Create chrome driver object
        WebDriver driver = new ChromeDriver();

//        Maximize the window
        driver.manage().window().maximize();

//        Open google home page https://www.google.com/

        driver.get("https://www.google.com/");

//        Wait for 3 seconds
        Thread.sleep(3000);

//        Go to the https://techproeducation.com/

        driver.get("https://techproeducation.com/");


//        Get the title and URL of the page

        String actualResult = driver.getTitle();
        System.out.println("actualResult = " + actualResult);

        String actualUrl = driver.getCurrentUrl();

        System.out.println("actualUrl = " + actualUrl);


//        Check if the title contains the word "Bootcamps" print console "Title contains Bootcamps" or "Title does not contain Bootcamps"

        if(actualResult.contains("Bootcamps")){

            System.out.println("Title contains Bootcamps");
        }else {

            System.out.println("Title does not contain Bootcamps");
        }
//        Check if the URL contains the word "techpro" print console "URL contains techpro" or "URL does not contain techpro”

        if (actualUrl.contains("techpro")){

            System.out.println("URL contains techpro");
        }else {

            System.out.println("URL does not contain techpro");
        }
//        Then go to https://medunna.com/

        driver.navigate().to("https://medunna.com/");

//        Get the title and check if it contains the word "MEDUNNA" and print "Title contains MEDUNNA" or "Title does not contain MEDUNNA”

        String medunnaTitleAc =  driver.getTitle();

        System.out.println(medunnaTitleAc);


        if (medunnaTitleAc.contains("MEDUNNA")){

            System.out.println("Title contains MEDUNNA");
        }else {

            System.out.println("Title does not contain MEDUNNA");
        }

//        Navigate Back to the previous webpage
        driver.navigate().back();
//        Refresh the page
        driver.navigate().refresh();
//        Navigate to forward
        driver.navigate().forward();
//        Wait for 3 seconds
        Thread.sleep(3000);
//        Close the browser
        driver.quit();



    }
}