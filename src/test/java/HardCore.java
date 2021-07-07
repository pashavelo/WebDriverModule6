import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class HardCore extends Precondition{

    @Test
    public void hardCore_Test() throws InterruptedException{

        driver.get("https://cloud.google.com/");
        Assert.assertTrue(driver.getTitle().contains("Cloud Computing Services  |  Google Cloud"));


        WebElement searchIcon = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("devsite-searchbox")));
        searchIcon.click();


        WebElement searchField = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        searchField.sendKeys("Google Cloud Platform Pricing Calculator");
        searchField.sendKeys(Keys.ENTER);



        WebElement searchResult = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@href='https://cloud.google.com/products/calculator' and @class='gs-title']")));
        searchResult.click();

        //Switching to iframe
        WebElement iFrame = driver.findElement(By.xpath("//iframe[contains(@name,'goog_')]"));
        driver.switchTo().frame(iFrame);
        driver.switchTo().frame("myFrame");


        WebElement numberOfInstances = new WebDriverWait(driver,5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@ng-model='listingCtrl.computeServer.quantity']")));
        numberOfInstances.sendKeys("4");

        WebElement seriesOfMachines = driver.findElement(By.xpath("//md-select[@name='series']/parent::md-input-container"));
        seriesOfMachines.click();


        WebElement seriesOfMachinesModelN1 = new WebDriverWait(driver,5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@value='n1']")));
        seriesOfMachinesModelN1.click();

        WebElement machineType = driver.findElement(By.xpath("//label[text()='Machine type']/parent::md-input-container"));
        machineType.click();


        WebElement machineTypeModel = new WebDriverWait(driver,5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")));
        machineTypeModel.click();

        WebElement gpusCheckBox = driver.findElement(By.xpath("//*[@aria-label='Add GPUs']"));
        gpusCheckBox.click();



        WebElement numberOfGpus = new WebDriverWait(driver,5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Number of GPUs']")));
        numberOfGpus.click();


        WebElement numberOfGpusModel = new WebDriverWait(driver,5)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("md-option[value='1'][class='ng-scope md-ink-ripple'][ng-disabled]")));
        numberOfGpusModel.click();

        WebElement gpuType = driver.findElement(By.xpath("//md-select[@placeholder='GPU type']"));
        gpuType.click();

        WebElement gpuTypeModel1 = new WebDriverWait(driver,5)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//md-option[@value='NVIDIA_TESLA_V100']")));
        gpuTypeModel1.click();

        WebElement localSSD = driver.findElement(By.xpath("//*[@placeholder='Local SSD']"));
        localSSD.click();

        WebElement localSSDModel1 = new WebDriverWait(driver,5)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='select_option_403' and @value='2']")));
        localSSDModel1.click();

        WebElement dataCenterLocation = driver.findElement(By.xpath("//*[@placeholder='Datacenter location']"));
        dataCenterLocation.click();

        WebElement dataCenterLocationModel1 = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By
                        .cssSelector("md-select-menu[class='md-overflow'] md-option[value='europe-west3'][ng-repeat*='fullRegionList']")));
        dataCenterLocationModel1.click();

        WebElement committedUsage = driver.findElement(By.xpath("//*[@placeholder='Committed usage']"));
        committedUsage.click();

        WebElement committedUsage1Year = new WebDriverWait(driver,5)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='md-select-menu-container md-active md-clickable'] md-option[value='1'][class='md-ink-ripple']")));
        committedUsage1Year.click();

        WebElement buttonAddToEstimate = driver.findElement(By.xpath("//*[@aria-label='Add to Estimate']"));
        buttonAddToEstimate.click();


        WebElement vmClassIsRegular = new WebDriverWait(driver,5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains (text(),'VM class: regular')]")));
        String vmClassIsRegularValue = vmClassIsRegular.getText();
        String vmClassIsRegularActual = "VM class: regular";
        Assert.assertEquals(vmClassIsRegularActual, vmClassIsRegularValue);

        WebElement instanceTypeIsN1Standard8 = driver.findElement(By.xpath("//*[contains (text(),'Instance type: n1-standard-8')]"));
        String instanceTypeIsN1Standard8Value = instanceTypeIsN1Standard8.getText();
        String instanceTypeIsN1Standard8Actual = "Instance type: n1-standard-8";
        Assert.assertEquals(instanceTypeIsN1Standard8Actual, instanceTypeIsN1Standard8Value);

        WebElement regionIsFrankfurt = driver.findElement(By.xpath("//*[contains (text(),'Region: Frankfurt')]"));
        String regionIsFrankfurtValue = regionIsFrankfurt.getText();
        String regionIsFrankfurtActual = "Region: Frankfurt";
        Assert.assertEquals(regionIsFrankfurtActual, regionIsFrankfurtValue);

        WebElement localSSDIs2x375GiB = driver.findElement(By.xpath("//*[contains (text(),'Total available local SSD space 2x375 GiB')]"));
        String localSSDIs2x375GiBValue = localSSDIs2x375GiB.getText();
        String localSSDIs2x375GiBActual = "Total available local SSD space 2x375 GiB";
        Assert.assertEquals(localSSDIs2x375GiBActual, localSSDIs2x375GiBValue);

        WebElement commitmentTerm = driver.findElement(By.xpath("//*[contains (text(),'Commitment term: 1 Year')]"));
        String commitmentTermValue = commitmentTerm.getText();
        String commitmentTermActual = "Commitment term: 1 Year";
        Assert.assertEquals(commitmentTermActual, commitmentTermValue);

        WebElement estimatedComponentCost = driver.findElement(By.xpath("//*[contains (text(),'Estimated Component Cost:\n" +
                "              USD 1,082.77\n" +
                "              per 1 month')]"));
        String estimatedComponentCostValue = estimatedComponentCost.getText();
        String estimatedComponentCostActual = "Estimated Component Cost: USD 1,082.77 per 1 month";
        Assert.assertEquals(estimatedComponentCostActual, estimatedComponentCostValue);

        //Start of HardCore Task
        WebElement emailEstimate = driver.findElement(By.xpath("//*[@type='button' and @id='email_quote']"));
        emailEstimate.click();


        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://www.crazymailing.com/");

        Assert.assertTrue(driver.getTitle().contains("Temporary Disposable Email - 10 minute mail"));

        WebElement mailAddressBox = new WebDriverWait(driver,5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='expire_block']")));

        String emailFromTenMinuteEMail = driver.findElement(By.xpath("//*[@id='email_addr'] ")).getText();
        System.out.println(emailFromTenMinuteEMail);

        driver.switchTo().window(tabs.get(0));

        driver.switchTo().frame(iFrame);
        driver.switchTo().frame("myFrame");


        WebElement emailEmailCalculatorForm = new WebDriverWait(driver,10)
        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='description' and @type='email']")));
        //Timeout
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        emailEmailCalculatorForm.sendKeys(emailFromTenMinuteEMail);

        WebElement buttonSendEmailOnEmailCalculatorForm = driver.findElement(By.xpath("//button[@type='button' and @aria-label='Send Email']"));
        buttonSendEmailOnEmailCalculatorForm.click();

        driver.switchTo().defaultContent();

        driver.switchTo().window(tabs.get(1));


        WebElement receivedEmailOnCrazyMail = new WebDriverWait(driver,60)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[contains(text(),'Google Cloud Platform Price Estimate')]")));
        receivedEmailOnCrazyMail.click();

        WebElement messFrame = driver.findElement(By.xpath("//*[@id='mess_frame'] "));
        driver.switchTo().frame(messFrame);

        WebElement totalEmailEstimatedCost = new WebDriverWait(driver,5)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'Estimated Monthly Cost: USD 1,082.77')]")));

        String totalEmailEstimatedValue = totalEmailEstimatedCost.getText();
        Assert.assertEquals(totalEmailEstimatedValue,"Estimated Monthly Cost: USD 1,082.77");

    }
    @AfterClass(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

}
