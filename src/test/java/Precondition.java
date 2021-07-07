import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class Precondition {

    protected static WebDriver driver;

    @BeforeClass

    public void Setup(){
        System.setProperty("webdriver.chrome.driver","C:/data/Webdrivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }



}
