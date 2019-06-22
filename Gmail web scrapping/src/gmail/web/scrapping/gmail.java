/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gmail.web.scrapping;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author gemme
 */
public class gmail {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.gecko.driver", "C:\\Gecko\\geckodriver.exe");
        // Create a new instance of the FireFox driver
        WebDriver driver = new FirefoxDriver();
        // Storing the Application Url in the String variable
        String url = "https://mail.google.com/mail";
        //Launch the localhost WebSite
        driver.get(url);

        WebElement email = driver.findElement(By.name("identifier"));
       

        email.sendKeys("gemmechumohammed@gmail.com");

        WebElement next = driver.findElement(By.id("identifierNext"));
        next.click();
        Thread.sleep(650);
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("0912154166");
        Thread.sleep(350);
        WebElement passnext = driver.findElement(By.id("passwordNext"));
        passnext.click();
        
        Thread.sleep(250);
        List<WebElement> mail=driver.findElements(By.xpath("//*[@class='zA zE']"));
        String message="";
        for(int i=0; i<mail.size(); i++){
            //System.out.println("main: "+ );
            String from="from: "+mail.get(i).findElement(By.className("zF")).getAttribute("name");
            String subject= "subject: "+mail.get(i).findElement(By.className("y6")).getText();
            message += from+ "  "+ subject+ "\n";
        }
        writeToFile(message);
        // Go back to Home Page
        //driver.navigate().back();
        // Go forward to Registration page
        //driver.navigate().forward();
        // Go back to Home page
        //driver.navigate().to(url);
        // Refresh browser
        //driver.navigate().refresh();
        // Close browser
       // driver.close();

    }
     public static void writeToFile(String data) throws IOException 
{
	FileWriter fileWriter = new FileWriter("unreadMail.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(data);
        printWriter.close();
}
}
