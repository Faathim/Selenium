import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pushpa {

	public static void main(String[] args) throws Exception {
		
		String projectPath = System.getProperty("user.dir");
		
		System.setProperty("webdriver.chrome.driver", projectPath+"//drivers/chromedriver/chromedriver.exe");
		WebDriver driver= new ChromeDriver();

		driver.get("https://en.wikipedia.org/wiki/Pushpa:_The_Rise");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(3000);
		WebElement release= driver.findElement(By.xpath("//div[text()='Release date']"));
		release.isDisplayed();
		String r= release.getText();
		WebElement date= driver.findElement(By.cssSelector("#mw-content-text > div.mw-parser-output > table.infobox.vevent > tbody > tr:nth-child(12) > td > div > ul > li"));
		String d= date.getText();

		System.out.println(r+": "+d);
		WebElement Country= driver.findElement(By.xpath("//th[text()='Country']"));
		String C= Country.getText();
		WebElement country= driver.findElement(By.cssSelector("#mw-content-text > div.mw-parser-output > table.infobox.vevent > tbody > tr:nth-child(14) > td"));
		String c=country.getText();
		System.out.println(c);
		
		
		driver.get("https://www.imdb.com/title/tt9389998/");
		Thread.sleep(3000);
		WebElement imdbr= driver.findElement(By.xpath("//li[@data-testid='title-details-releasedate']"));
		js.executeScript("arguments[0].scrollIntoView(true);", imdbr);
		String imdbR= imdbr.getText();
		WebElement imdbdate= driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/section[1]/div/section/div/div[1]/section[9]/div[2]/ul/li[1]/div/ul/li/a"));
		String imdbDate= imdbdate.getText();
		System.out.println(imdbDate);
		
		WebElement imdbCountry= driver.findElement(By.xpath("//span[text()='Country of origin']"));
		String imdbcountry= imdbCountry.getText();

		
		WebElement imdbInd= driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/section[1]/div/section/div/div[1]/section[9]/div[2]/ul/li[2]/div/ul"));
		String imdbIndia= imdbInd.getText();
		System.out.println(imdbcountry+ ": "+ imdbIndia);

		Thread.sleep(3000);
		
		
		
		String[] arrOfStr= imdbDate.split("(United States)", 5);
		 for (String a : arrOfStr)
	            System.out.println(a);
		 
		
		 if(d.contentEquals(imdbDate))
		 {
			 System.out.println("Date Matches");
		 }
		 else {
			 System.out.println("Date is not Matching");
		 }
		 
		 if(c.contentEquals(imdbIndia)) {
			 System.out.println("Country Matches");
		 }
		 else
		 {
			 System.out.println("Country is not Matching");
		 }
		driver.close();
		
		
		
	}
}
