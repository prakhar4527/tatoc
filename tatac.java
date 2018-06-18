package assignment1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
	}
}
