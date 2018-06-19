package assignment1;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Cookie;

public class tatac{

	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver");
		WebDriver driver=new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc");
		driver.findElement(By.linkText("Basic Course")).click();
		//ele.click();
		driver.findElement(By.className("greenbox")).click();
		//ele1.click();
		int flag=0;
		//WebElement a=driver.findElement(By.id("answer"));
		//WebElement b=driver.findElement(By.id("child"));
		driver.switchTo().frame("main");
		WebElement b1=driver.findElement(By.xpath("//*[text()[contains(.,'Box 1')]]"));
		while(flag==0)
		{
			String s1 = b1.getAttribute("class");
			driver.switchTo().frame("child");
			WebElement b2=driver.findElement(By.xpath("//*[text()[contains(.,'Box 2')]]"));
			String s2 = b2.getAttribute("class");
			driver.switchTo().defaultContent();
			driver.switchTo().frame("main");
			if(s1.equals(s2))
			{
				flag=1;
				WebElement pro=driver.findElement(By.xpath("//*[text()[contains(.,'Proceed')]]"));
				pro.click();
			}
			else
			{
				WebElement re=driver.findElement(By.xpath("//*[text()[contains(.,'Repaint Box 2')]]"));
				re.click();
			}
		}
		driver.switchTo().defaultContent();
		WebElement drag=driver.findElement(By.id("dragbox"));
		WebElement drop=driver.findElement(By.id("dropbox"));
		Actions builder = new Actions(driver);
		builder.dragAndDrop(drag, drop).perform();
		//Action dragAndDrop = builder.clicdragAndDrop(element, target).perform();kAndHold(drag).moveToElement(drop).release(drag).build();
	    //dragAndDrop.perform();
		WebElement pro1=driver.findElement(By.xpath("//*[text()[contains(.,'Proceed')]]"));
		pro1.click();
		WebElement launch=driver.findElement(By.xpath("//*[text()[contains(.,'Launch Popup Window')]]"));
		launch.click();
		ArrayList windowsList =new ArrayList(driver.getWindowHandles());
		String window1= ((String)windowsList.get(1));
		 driver.switchTo().window(window1);
		 driver.findElement(By.id("name")).sendKeys("Prakhar");
		 driver.findElement(By.id("submit")).click();
		 String window0= ((String)windowsList.get(0));
		 driver.switchTo().window(window0);
		 driver.findElement(By.linkText("Proceed")).click();
		 driver.findElement(By.linkText("Generate Token")).click();
		 //driver.findElement(By.linkText("Generate Token")).click();
		 String Token = driver.findElement(By.id("token")).getText();
		 System.out.println(Token);
		 String substring1=Token.substring(7);
		 Cookie name = new Cookie("Token", substring1);
		 driver.manage().addCookie(name);
		 driver.findElement(By.linkText("Proceed")).click(); 
	}
}
