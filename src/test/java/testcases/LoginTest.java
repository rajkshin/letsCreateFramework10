package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.LoginPage;

import java.io.IOException;

public class LoginTest extends BaseClass {

    @Test
    public void loginTest() throws InterruptedException, IOException {

        LoginPage loginpage = new LoginPage(driver);

        loginpage.setUserName(username);
        logger.info("username is provided");
        Thread.sleep(5000);
        loginpage.setPassWord(password);
        logger.info("password is provided");
        loginpage.clickSubmit();
        logger.info("clicked in submit button");

        String url = driver.getCurrentUrl();
        logger.info("navigated to homepage and url is: " + url);

        if (url.contains("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList")) {
            Assert.assertTrue(true);
            logger.info("login test passed");
            captureScreen(driver,"loginPassed");
        } else {
            Assert.assertTrue(false);
            logger.info("login test failed");
            captureScreen(driver,"faliedLogin");
        }
    }


}
