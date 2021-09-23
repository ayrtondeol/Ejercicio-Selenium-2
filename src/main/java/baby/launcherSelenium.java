package baby;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class launcherSelenium {
		protected ChromeDriver driver;
		protected WebDriverWait waitDriver;
		

	public void launchSelenium(String url)
	{
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	    waitDriver = new WebDriverWait(driver, 20);
	}
	}

