package testcases;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utils.ReadConfig;
import org.apache.log4j.Logger;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseClass {
    public static WebDriver driver;
    ReadConfig readconfig = new ReadConfig();

    public String baseURL = readconfig.getApplicationURL();
    public String username = readconfig.getUserName();
    public String password = readconfig.getPassword();

    public static Logger logger;

    @Parameters("browser")
    @BeforeClass
    public void setUp(String br) {
        logger=Logger.getLogger("OrangeHRM");
        PropertyConfigurator.configure("log4j.properties");



        if (br.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/Drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
//        else if(br.equals("firefox"))
//        {
//            System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
//            driver = new FirefoxDriver();
//        }
//        else if(br.equals("ie"))
//        {
//            System.setProperty("webdriver.ie.driver",readconfig.getIEPath());
//            driver = new InternetExplorerDriver();
//        }
        logger.info("maximizing windows");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        logger.info("opening OrangeHRM website");
        driver.get(baseURL);

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public void captureScreen(WebDriver driver, String tname) throws IOException, IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/screenshots/" + tname + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }

}
