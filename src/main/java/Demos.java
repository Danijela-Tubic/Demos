import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demos {

    /*Napisati dva smoke testa za https://www.telerik.com/support/demos:
Proveriti da klikom na Desktop odlazimo na tu sekciju
Proveriti da klikom na Mobile odlazimo na tu sekciju
Koristiti TestNG, asserte.*/

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tubic\\Desktop\\IT BOOTCAMP\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://www.telerik.com/support/demos");
        driver.manage().window().maximize();

    }

    @Test
    public void testDesktopButton() {

        //Proveriti da klikom na Desktop odlazimo na tu sekciju:
        WebElement desktopBtn = driver.findElement(By.xpath("//*[@id=\"ContentPlaceholder1_T53129E6C012_Col00\"]/nav/div/div[2]/a[2]"));
        desktopBtn.click();

        //Poređenje naslova:
        WebElement desktop = driver.findElement(By.id("desktop"));
        String expectedDesktop = "Desktop";
        String actualDesktop = desktop.getText();
        Assert.assertEquals(actualDesktop, expectedDesktop);

    }

    @Test
    public void testMobileButton() {

        //Proveriti da klikom na Mobile odlazimo na tu sekciju:
        WebElement mobileElement = driver.findElement(By.xpath("//*[@id=\"ContentPlaceholder1_T53129E6C012_Col00\"]/nav/div/div[2]/a[3]"));
        mobileElement.click();

        //Poređenje Mobile naslova:
        WebElement mobile = driver.findElement(By.id("mobile"));
        String actualMobile = mobile.getText();
        String expectedMobile = "Mobile";
        Assert.assertEquals(actualMobile, expectedMobile);

    }

    @AfterClass
    public void afterMethod() {
        driver.close();
    }
}
