package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver browser;
    WebDriverWait wait;

    public LoginPage(WebDriver browserDriver){
        browser = browserDriver;

        // wait for page to load
        wait = new WebDriverWait(browser, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
    }

    public void setEmailAddress(String emailAddress){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        WebElement emailTextBox = browser.findElement(By.id("email"));
        emailTextBox.clear();
        emailTextBox.sendKeys( emailAddress);
    }

    public  void setPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwd")));
        WebElement passwordTextBox = browser.findElement(By.id("passwd"));
        passwordTextBox.clear();
        passwordTextBox.sendKeys(password);
    }

    public  void clickSignInButton(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("SubmitLogin")));
        WebElement signInButton = browser.findElement(By.id("SubmitLogin"));
        signInButton.click();
    }
}
