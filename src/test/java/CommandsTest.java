import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommandsTest {
    public static void main(String[] args) {
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--incognito");
        WebDriver driver=new ChromeDriver(options);
        Wait<WebDriver> wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's enabled!\"]")));
        System.out.println("Input field enabled and text visible");

        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//button[@onclick='swapInput()']")),"Disable"));
        System.out.println("Button text changed successfully");

        driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("Bootcamp");
        driver.findElement(By.xpath("//input[@type=\"text\"]")).clear();

        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        if(driver.findElement(By.id("column-a")).getLocation().y==driver.findElement(By.id("column-b")).getLocation().y){
            System.out.println("Columns A and B aligned successfully");
        }

        driver.close();
    }
}