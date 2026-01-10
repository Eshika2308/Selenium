package tutorialsNinja.RegisterPage;


/*Email verification
* Internet Message App protocol enabled or not to run selenium code, without IMAP no one can access your email
* For third party application we need to give passcode
* 2 factor authentication should be on, if this is not on IMAP enabling will not be possible
*  */


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;
import java.time.Duration;
import java.util.Properties;


public class TC_RF_002 {

    @Test
    public void verifyForgotPasswordEmail(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://www.amazon.in");

        driver.findElement(By.xpath("//span[text()='Hello, sign in']")).click();
        driver.findElement(By.className("a-input-text")).sendKeys("meshrameshika.2308@gmail.com");
        ////input[@class='a-button-input']

        driver.findElement(By.className("a-button-input")).click();
       //driver.findElement(By.id("auth-fpp-link-bottom")).click();
        driver.findElement(By.xpath("//*[@id='auth-fpp-link-bottom']")).click();
        //span.a-button-text#a-autoid-0-announce

       // driver.findElement(By.xpath("//[@id='a-autoid-0-announce' and contains(@class,'a-button-text')]")).click();
        driver.findElement(By.id("continue")).click();

        String email = "meshrameshika.2308@gmail.com";
        String appPasscode ="karr gidg jxdm yiqj";
        String host = "imap.gmail.com";
        String mailStoreType = "imaps";



      try {

          Properties props = new Properties();
          props.put("mail.store.protocol", mailStoreType);
          props.put("mail.imaps.host", host);
          props.put("mail.imaps.ssl.enable", "true");
          props.put("mail.imaps.port", "993"); // trust server cert
          props.put("mail.imaps.connectiontimeout", "10000"); // ms
          props.put("mail.imaps.timeout", "10000");

          //Session object
          Session emailSession = Session.getInstance(props);
          Store store = emailSession.getStore(mailStoreType);
          store.connect(host, email, appPasscode);

          Folder inbox =  store.getFolder("INBOX");
          inbox.open(Folder.READ_ONLY);

          Message[] messages = inbox.getMessages();

          Message latestMessage = messages[messages.length - 1];

          System.out.println("From: " +
                  InternetAddress.toString(latestMessage.getFrom()));
          System.out.println("To: " +
                  InternetAddress.toString(latestMessage.getReplyTo()));
          System.out.println("Subject: " + latestMessage.getSubject());
          System.out.println("Received Date: " + latestMessage.getReceivedDate());
          //System.out.println("Body:"+ getTextFromMessage(message));
          inbox.close(false);
          store.close();
      } catch (Exception e) {
          e.printStackTrace();
      } finally {
          driver.quit();
      }

    }

//code avilable in repo
    private String getTextFromMessage(Message message) {
        return null;
    }
}
