package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver browser;
    WebDriverWait wait;

    public  LoginPage(WebDriver browserDriver){
        browser = browserDriver;

        // wait for page to load
        wait = new WebDriverWait(browser, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
    }

    public void setEmailAddress(String emailAddress){
        WebElement emailTextBox = browser.findElement(By.id("email"));
        emailTextBox.sendKeys( emailAddress);
    }

    public  void setPassword(String password){
        WebElement passwordTextBox = browser.findElement(By.id("passwd"));
        passwordTextBox.sendKeys(password);
    }

    public  void clickSignInButton(){
        WebElement signInButton = browser.findElement(By.id("SubmitLogin"));
        signInButton.click();
    }
}
