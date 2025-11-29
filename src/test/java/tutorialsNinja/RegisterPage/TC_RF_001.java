package tutorialsNinja.RegisterPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

public class TC_RF_001 {

    @Test
    public  void verifyRegisteringWithMandatoryFeilds () {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();

        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

        // driver.findElement(By.xpath("//input [@placeholder=\"First Name\" and @id=\"input-firstname\"]")).click();
        driver.findElement(By.id("input-firstname")).sendKeys("Eshika");

        driver.findElement(By.id("input-lastname")).sendKeys("Mankar");
        driver.findElement(By.id("input-email")).sendKeys(generateNewEmail());
        driver.findElement(By.id("input-telephone")).sendKeys("9850600371");
        driver.findElement(By.id("input-password")).sendKeys("1234555");
        driver.findElement(By.id("input-confirm")).sendKeys("1234555");
        driver.findElement(By.xpath("//input [@type=\"checkbox\"]")).click();
        driver.findElement(By.xpath("//input [@type=\"submit\"]")).click();

    }

    public String generateNewEmail() {

//        String noColonDate = new Date().toString().replaceAll(":", "");
//        System.out.println(noColonDate);
//        String noColonnospace = noColonDate.replaceAll(" ", "");
//        System.out.println(noColonnospace);
//        String emailWithTimeStamp = noColonnospace + "@gmail.com";
        //System.out.println(emailWithTimeStamp);

        return new Date().toString().replaceAll(":", "").replaceAll(" ", "")+"@gmail.com";

    }

}
