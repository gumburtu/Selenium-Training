package utilities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public abstract class TestBase {

    protected WebDriver driver;

    @BeforeEach
    protected void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterEach
    protected void tearDown() {
        driver.quit();
    }

    //Hard wait
    protected void waitForSecond(int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Select Visible Text
    protected void selectVisible(WebElement ddm,String option){
        Select select = new Select(ddm);
        select.selectByVisibleText(option);
    }

    //index ile window  handle
    protected void switchToWindowByIndex(int index){
        driver.switchTo().window(driver.getWindowHandles().toArray()[index].toString());
    }


}