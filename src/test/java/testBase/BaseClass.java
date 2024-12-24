package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	public Properties p;

	
	@BeforeClass()
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws IOException {
		Properties p = new Properties();
		p.load(new FileInputStream("./src/test/resources/config.properties"));
		if(p.getProperty("exe_env").equalsIgnoreCase("local"))
		{
		switch(br.toLowerCase())
		{
		case "chrome" : driver = new ChromeDriver();break;
		case "edge" : driver = new EdgeDriver();break;
		}
		}
		if(p.getProperty("exe_env").equalsIgnoreCase("remote"))
		{
			System.out.println("I entered remote section");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			switch(os.toLowerCase())
			{
			case "windows" : capabilities.setPlatform(Platform.WIN11);break;
			case "linux" : capabilities.setPlatform(Platform.LINUX);break;
			
			}
			if(br.equalsIgnoreCase("chrome"))
			{
				capabilities.setBrowserName("chrome");
			}
			else if(br.equalsIgnoreCase("edge"))
			{
				capabilities.setBrowserName("MicrosoftEdge");
			}
			else if(br.equalsIgnoreCase("firefox"))
			{
				capabilities.setBrowserName("firefox");
			}
			
			driver = new RemoteWebDriver(new URL("http://localhost:4444"),capabilities);
		}
		driver.manage().window().maximize();
		driver.get(p.getProperty("url"));
	}
	
	@AfterClass
	public void teatDown()
	{
		System.out.println("entered quite section");
		driver.quit();
	}
	
	
	public String randomStringGenerator() {
		return RandomStringUtils.randomAlphabetic(5);
	}

	public String randomNumberGenerator() {
		return RandomStringUtils.randomNumeric(5);
	}

	public String captureScreen(String tname) {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		File targetFile = new File(targetFilePath);
		sourceFile.renameTo(targetFile);

		return targetFilePath;
	}

}
