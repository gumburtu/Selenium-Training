package day05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Q3_FileDownload extends TestBase {

//    Go to https://testpages.herokuapp.com/
//    Click on File Downloads
//    Click on Server Download
//    Verify that file is downloaded

    @Test
    public void test03() throws InterruptedException {


//        Go to https://testpages.herokuapp.com/
        driver.get("https://testpages.herokuapp.com/");

//        Click on File Downloads
        WebElement fileDownloadsButton = driver.findElement(By.xpath("//a[@id='download']"));
//       WebElement fileDownloadsButton = driver.findElement(By.id("download"));

        fileDownloadsButton.click();
//        Click on Server Download

        WebElement serverDownload = driver.findElement(By.id("server-download"));

        serverDownload.click();
        Thread.sleep(3000);
//        Verify that file is downloaded

        String pathOfFile = System.getProperty("user.home") + "/Downloads/textfile.txt";

        Assertions.assertTrue(Files.exists(Paths.get(pathOfFile)));

        try{

            Files.delete(Paths.get(pathOfFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}