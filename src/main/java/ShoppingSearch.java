import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

public class ShoppingSearch {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver Naveen = new ChromeDriver();
        Naveen.manage().window().maximize();
        Naveen.get("https://www.amazon.com");

        String Search= "iphone 11";
        //WebElement search = Naveen.findElement(By.cssSelector("#twotabsearchtextbox"));
        WebElement search = Naveen.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        search.sendKeys(Search);
        search.sendKeys(Keys.ENTER);

        List<String> actualResult = Naveen.findElements(By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']")).stream()
                .map(element-> element.getText().toLowerCase())
                .collect(Collectors.toList());

        //Assert.assertTrue(actualResult.stream().allMatch(item->item.contains(Search)));

        List<String> expectedResult = actualResult.stream()
                .filter(item->item.contains(Search))
                .collect(Collectors.toList());

        Assert.assertEquals(expectedResult, actualResult);


        Naveen.close();

    }
}
