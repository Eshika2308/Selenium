package tutorialsNinja.RegisterPage;


import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

//TC- Verify registering with all mandatory fields

public class TC_RF_003 {
    @Test
    public  void verrifyAccountsWithAllFeilds() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("http://tutorialsninja.com");

        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

        driver.findElement(By.id("input-firstname")).sendKeys("Eshika");

        driver.findElement(By.id("input-lastname")).sendKeys("Mankar");
        driver.findElement(By.id("input-email")).sendKeys(generateNewEmail());
        driver.findElement(By.id("input-telephone")).sendKeys("9850600371");
        driver.findElement(By.id("input-password")).sendKeys("1234555");
        driver.findElement(By.id("input-confirm")).sendKeys("1234555");

        driver.findElement(By.xpath("//input [@name='newsletter' and @value='1']")).click();
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input [@value='Continue']")).click();
//        driver.findElement(By.xpath("//input [@type=\"checkbox\"]")).click();
//        driver.findElement(By.xpath("//input [@type=\"submit\"]")).click();

        Assert.isTrue(driver.findElement(By.linkText("Logout")).isDisplayed(), "Logout link is not displayed");
        Assert.isTrue(driver.findElement(By.xpath("//div[@id='content']//h1")).getText().equals("Your Account Has Been Created!"), "Account creation title does not match");

    }
    public static String generateNewEmail() {
        return new Date().toString().replaceAll(":", "").replaceAll(" ", "") + "@gmail.com";
    }
}
