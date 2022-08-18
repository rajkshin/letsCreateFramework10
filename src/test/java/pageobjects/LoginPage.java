package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
    WebDriver ldriver;

    public LoginPage(WebDriver rdriver) {
        this.ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(id = "txtUsername")
    private WebElement userName;

    @FindBy(xpath = "//div[@id='divPassword']/input")
    private WebElement passWord;

    @FindBy(id = "btnLogin")
    private WebElement submitButton;

    public void setUserName(String uname) {
        userName.sendKeys(uname);
    }

    public void setPassWord(String passwd) throws InterruptedException {passWord.sendKeys(passwd);  }

    public void clickSubmit() {submitButton.click(); }


}
