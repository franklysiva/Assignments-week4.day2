package week4.day2;

import java.util.Set;
import java.util.List;
import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main (String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leaftaps.com/opentaps/control/login");
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager",Keys.TAB);
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//div[@class='frameSectionBody']//li[4]")).click();
		driver.findElement(By.xpath("(//div[@class='subSectionBlock']//a[1])[1]")).click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> listAllWindows1 = new ArrayList<>(windowHandles1);
		Thread.sleep(2000);
		driver.switchTo().window(listAllWindows1.get(1));
		driver.findElement(By.xpath("(//div[@class='x-grid3-body']//table/tbody/tr[1]/td[3])[1]")).click();
		Thread.sleep(2000);
		driver.switchTo().window(listAllWindows1.get(0));
		driver.findElement(By.xpath("(//div[@class='subSectionBlock']//a[1])[2]")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> listAllWindows2 = new ArrayList<>(windowHandles2);
		Thread.sleep(2000);
		driver.switchTo().window(listAllWindows2.get(1));
		driver.findElement(By.xpath("(//div[@class='x-grid3-body']//table/tbody/tr[1]/td[3])[2]")).click();
		Thread.sleep(2000);
		driver.switchTo().window(listAllWindows2.get(0));
		driver.findElement(By.xpath("(//div[@class='subSectionBlock']//a[1])[3]")).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(2000);
		String title = driver.getTitle();
		System.out.println(title);
	}
}
