import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class BringItOn extends Precondition{

    @Test
    public void bringItOn_Test() throws InterruptedException{

        driver.get("https://pastebin.com");
        Assert.assertTrue(driver.getTitle().contains("Pastebin.com - #1 paste tool since 2002!"));

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("postform-text")));

        WebElement postFormText = driver.findElement(By.id("postform-text"));
        postFormText.sendKeys("git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force");

        WebElement pasteName = driver.findElement(By.id("postform-name"));
        pasteName.sendKeys("how to gain dominance among developers");

        WebElement pasteExpiration = driver.findElement(By.cssSelector("#select2-postform-expiration-container"));
        pasteExpiration.click();

        new WebDriverWait(driver,5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='select2-results__option' and contains (., '10 Minutes')]")));
        WebElement expiration10Minutes = driver.findElement(By.xpath("//*[@class='select2-results__option' and contains (., '10 Minutes')]"));
        expiration10Minutes.click();

        WebElement syntaxHighlighting = driver.findElement(By.xpath("//span[@id='select2-postform-format-container']"));
        syntaxHighlighting.click();


        new WebDriverWait(driver,5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[1]/span[2]/span[1]/span[2]/ul[1]/li[2]/ul[1]/li[1]")));
        WebElement syntaxHighlightingBash = driver.findElement(By.xpath("//body[1]/span[2]/span[1]/span[2]/ul[1]/li[2]/ul[1]/li[1]"));
        syntaxHighlightingBash.click();

        WebElement buttonCreateNewPaste = driver.findElement(By.xpath("//button[contains(text(),'Create New Paste')]"));
        buttonCreateNewPaste.click();




        new WebDriverWait(driver,5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'how to gain dominance among developers')]")));

        Assert.assertTrue(driver.getTitle().contains("how to gain dominance among developers"));

        WebElement bashHighlightedGreen = driver.findElement(By.className("kw2"));
        String green = bashHighlightedGreen.getCssValue("color");
        String hexGreen = Color.fromString(green).asHex();
        Assert.assertEquals("#B9CA4A",hexGreen.toUpperCase());

        WebElement bashHighlightedBlue = driver.findElement(By.className("re5"));
        String blue = bashHighlightedBlue.getCssValue("color");
        String hexBlue = Color.fromString(blue).asHex();
        Assert.assertEquals("#7AA6DA", hexBlue.toUpperCase());


        WebElement textArea = driver.findElement(By.className("textarea"));
        String textAreaValue = textArea.getAttribute("value");
        String actualText = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
        Assert.assertEquals(actualText, textAreaValue);


    }
    @AfterClass(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

}
