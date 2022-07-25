package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {
	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//b[@id='topic']//following::input")).sendKeys("Handled Frame 1 Text Input");
		driver.switchTo().frame(0);
		driver.findElement(By.id("a")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		WebElement animalsElement = driver.findElement(By.id("animals"));
		Select animal = new Select(animalsElement);
		animal.selectByVisibleText("Avatar");
		driver.close();
	}
}
