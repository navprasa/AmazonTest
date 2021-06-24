import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShoppingSearch {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver Naveen = new ChromeDriver();
        Naveen.manage().window().maximize();
        Naveen.get("https://www.amazon.com");

        //WebElement search = Naveen.findElement(By.cssSelector("#twotabsearchtextbox"));
        WebElement search = Naveen.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        search.sendKeys("Iphone 11");
        search.sendKeys(Keys.ENTER);


        //Naveen.close();

    }
}
