import Pages.HomePage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Pages.LoginPage;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Linear Shopping Cart tests for Java
public class POMCartTests {

    @Test
    public void POMAddToCartTest() {

        // initialisation
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Desktop\\automation\\chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(browser, 10);
        browser.manage().window().maximize();

        // go to website
        browser.get("http://automationpractice.com/");

        // navigate to login page
        HomePage homePage = new HomePage(browser);
        homePage.clickSignInButton();

        // log in
        LoginPage loginPage = new LoginPage(browser);
        loginPage.setEmailAddress("ishani@liveroom.xyz");
        loginPage.setPassword("automation@2021");
        loginPage.clickSignInButton();

        // navigate back to home page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.home")));
        WebElement homeLink = browser.findElement(By.cssSelector("a.home"));
        homeLink.click();

        // select the first product
        List<WebElement> productLinks = browser.findElements(By.cssSelector("a.product-name"));
        wait.until(ExpectedConditions.elementToBeClickable(productLinks.get(0)));
        productLinks.get(0).click();

        // add 1 item to the shopping cart
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='add_to_cart']/button")));
        WebElement addToCartButton = browser.findElement(By.xpath("//p[@id='add_to_cart']/button"));
        addToCartButton.click();

        // proceed to checkout
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Proceed to checkout']")));
        WebElement proceedToCheckoutButton = browser.findElement(By.xpath("//a[@title='Proceed to checkout']"));
        proceedToCheckoutButton.click();

        // verify we have 1 item in the shopping cart
        String numProductsLabelText = browser.findElement(By.id("summary_products_quantity")).getText();
        int spaceLocation = numProductsLabelText.indexOf(" ");
        int numProducts = Integer.parseInt(numProductsLabelText.substring(0, spaceLocation));
        assertEquals(numProducts, 1, "Expected number of products in shopping cart was 1 but actual value was: " + Integer.toString(numProducts));

        browser.quit();
    }
}

