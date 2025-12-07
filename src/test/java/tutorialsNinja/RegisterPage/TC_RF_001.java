package tutorialsNinja.RegisterPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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

        //Assertions
        Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());

        String expectedTitle ="Your Account Has Been Created!";
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']//h1")).getText(),expectedTitle);
        String detailsOne ="Congratulations! Your new account has been successfully created!";

        String detailsTwo="You can now take advantage of member privileges to enhance your online shopping experience with us.";

        String detailsThree="If you have ANY questions about the operation of this online shop, please e-mail the store owner.";

        String detailsFour="contact us";
        String expectedProperDetails = driver.findElement(By.id("content")).getText();


        Assert.assertTrue(expectedProperDetails.contains(detailsOne));
        Assert.assertTrue(expectedProperDetails.contains(detailsTwo));
        Assert.assertTrue(expectedProperDetails.contains(detailsThree));
        Assert.assertTrue(expectedProperDetails.contains(detailsFour));


        driver.findElement(By.xpath("//div[@class='pull-right']")).click();
        //driver.findElement(By.xpath(//a [text ()='Continue']));

        Assert.assertTrue(driver.findElement(By.xpath("//li//a[text() ='Edit your account information']")).isDisplayed());

        driver.quit();


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
