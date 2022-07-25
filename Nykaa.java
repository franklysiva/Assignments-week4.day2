package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.nykaa.com");
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement brandsElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='brands']")));
		Actions action = new Actions(driver);
		action.moveToElement(brandsElement).perform();
		WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("brandSearchBox")));
		searchBox.click();
		searchBox.sendKeys("L'Oreal Paris", Keys.ENTER);
		Thread.sleep(5000);
		WebElement brandSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()=\"L'Oreal Paris\"])[1]")));
		brandSelect.click();
		WebElement brandNameWithCount = driver.findElement(By.tagName("h1"));
		String brandName = brandNameWithCount.getText().substring(0, brandNameWithCount.getText().length() - 5).trim();
		if (brandName.equals("L'Oreal Paris")) {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@id='filter-sort']//span[@class='sort-name']")).click();
			WebElement custTopRated = wait.until(ExpectedConditions.elementToBeClickable
					(By.xpath("//div[@class='control-value']//span[contains(text(),'customer top rated')]")));
			custTopRated.click();
			driver.findElement(By.xpath("//div[@id='first-filter']")).click();
			WebElement hairElement = driver.findElement(By.xpath("//span[text()='Hair']"));
			WebElement hairEle = wait.until(ExpectedConditions.elementToBeClickable(hairElement));
			hairEle.click();
			WebElement hairCare = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Hair Care']")));
			hairCare.click();
			WebElement shampoo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Shampoo']")));
			shampoo.click();
			WebElement concern = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Concern']")));
			concern.click();
			WebElement colorProtection = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Color Protection']")));
			colorProtection.click();
			WebElement text = driver.findElement(By.xpath("//span[text()='Shampoo']"));
			if (text.getText().equals("Shampoo")) {
				Thread.sleep(5000);
				driver.findElement(By.xpath("//div[text()=\"L'Oreal Paris Colour Protect Shampoo\"]")).click();
				Set<String> windowHandles1 = driver.getWindowHandles();
				List<String> listAllWindows1 = new ArrayList<>(windowHandles1);
				Thread.sleep(2000);
				driver.switchTo().window(listAllWindows1.get(1));
				driver.findElement(By.xpath("//select[@title='SIZE']")).click();
				driver.findElement(By.xpath("//select[@title='SIZE']/option[@value='0']")).click();
				WebElement mrpElement = driver.findElement(By.xpath("((//div[@class='css-1d0jf8e'])[1]//span)[2]"));
				System.out.println("MRP: " + mrpElement.getText().substring(1));
				driver.findElement(By.xpath("(//span[@class='btn-text'])[1]")).click();
				Thread.sleep(2000);
				WebElement cartButton = driver.findElement(By.xpath("//span[@class='cart-count']//parent::button"));
				cartButton.click();
				WebElement iframeElement = driver.findElement(By.xpath("//iframe[@class='css-acpm4k']"));
				driver.switchTo().frame(iframeElement);
				Thread.sleep(2000);
				WebElement grandTotal = driver.findElement(
						By.xpath("//div[@class='cart-iframe']//div[@class='first-col']//div[@class='value']"));
				String cartGrandTotal = grandTotal.getText().substring(1);
				System.out.println("Grand Total is = " +cartGrandTotal);
				driver.findElement(By.xpath("//span[text()='Proceed']")).click();
				driver.switchTo().defaultContent();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();
				WebElement chkGrandTotal = driver
						.findElement(By.xpath("//i[@class='icon']//parent::div[@class='value']//span"));
				System.out.println("Grand Total Check = " + chkGrandTotal.getText());
				if (cartGrandTotal.equals(chkGrandTotal.getText()))
					System.out.println("Grand Total Price in Cart and Checkout Page is Same");
			}
		}
		driver.quit();
	}
}
