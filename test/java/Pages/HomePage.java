package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver browser;
    WebDriverWait wait;

    public HomePage(WebDriver browserDriver ){
        browser = browserDriver;

        //wait for the page to load
        wait = new WebDriverWait(browser, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.login")));
    }

    public void clickSignInButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.login")));
        WebElement signInLink = browser.findElement(By.cssSelector("a.login"));
        signInLink.click();
    }
}
