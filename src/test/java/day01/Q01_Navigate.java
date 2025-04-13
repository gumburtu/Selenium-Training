package day01;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q01_Navigate {


    //        Set Driver Path
    //         Create chrome driver object
    //         Maximize the window
    //         Open techproeducation home page https://techproeducation.com/
    //         Minimize this window
    //         Navigate to google home page https://www.google.com/
    //         Maximise the window
    //         Open https://www.amazon.com as a new tab or new window
    //         Navigate back to google
    //         Navigate forward to amazon
    //         Refresh the page
    //         Close/Quit the browser
    //         And last step : print "ALL OK" on console


    @Test
    public void test() throws InterruptedException {


        //        Set Driver Path

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

        //         Create chrome driver object
        WebDriver driver = new ChromeDriver();

        //         Maximize the window

        driver.manage().window().maximize();

        //         Open techproeducation home page https://techproeducation.com/

        driver.get("https://techproeducation.com/");

        // * Alternatif bir yol olarak navigate().to() methodu kullanilabilir....

//        driver.navigate().to("https://techproeducation.com/");

        //         Minimize this window
        driver.manage().window().minimize();

        //         Navigate to google home page https://www.google.com/

        driver.navigate().to("https://www.google.com/");


        //         Maximise the window
        driver.manage().window().maximize();

        //         Open https://www.amazon.com as a new tab or new window
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.amazon.com");


        Thread.sleep(3000);
        //         Navigate back to google
        driver.navigate().back();

        Thread.sleep(3000);
        //         Navigate forward to amazon

        driver.navigate().forward();

        Thread.sleep(3000);
        //         Refresh the page
        driver.navigate().refresh();
        //         Close/Quit the browser
        driver.close(); // close methodu driverin oldugu pencereyi kapatir sadece...

        driver.quit();  // Quit methodu butun pencereleri kapatir


        //         And last step : print "ALL OK" on console

        System.out.println("ALL OK");


    }
}