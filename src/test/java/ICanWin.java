import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


public class ICanWin extends Precondition{

    @Test
    public void iCanWin_Test() throws InterruptedException {

        driver.get("https://pastebin.com");
        Assert.assertTrue(driver.getTitle().contains("Pastebin.com - #1 paste tool since 2002!"));

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("postform-text")));

        WebElement postFormText = driver.findElement(By.id("postform-text"));
        postFormText.sendKeys("Hello from WebDriver");



        WebElement pasteName = driver.findElement(By.id("postform-name"));
        pasteName.sendKeys("helloweb");

        WebElement pasteExpiration = driver.findElement(By.cssSelector("#select2-postform-expiration-container"));
        pasteExpiration.click();

//        WebElement pasteExpiration = driver.findElement(By.id("postform-expiration"));
//        pasteExpiration.click();

        new WebDriverWait(driver,5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='select2-results__option' and contains (., '10 Minutes')]")));
        WebElement expiration10Minutes = driver.findElement(By.xpath("//*[@class='select2-results__option' and contains (., '10 Minutes')]"));
        expiration10Minutes.click();

        //I can`t understand why this is not working
//        Select select = new Select(pasteExpiration);
//        select.selectByVisibleText("10 Minutes");
//        select.selectByValue("10M");


        WebElement buttonCreateNewPaste = driver.findElement(By.xpath("//button[contains(text(),'Create New Paste')]"));
        buttonCreateNewPaste.click();

    }
    @AfterClass(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
