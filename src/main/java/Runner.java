import com.amazon.pages.HomePage;
import com.amazon.pages.SearchResultsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class Runner {

    private static final String Search_Phrase= "iphone 11";
    private static WebDriver Naveen;

    @BeforeAll
    public static void LoadDriver(){
        WebDriverManager.chromedriver().setup();
        Naveen = new ChromeDriver();
        Naveen.manage().window().maximize();
    }

    @Test
    public void run() {

        Naveen.get("https://www.amazon.com");
        HomePage homePage = new HomePage(Naveen);
        SearchResultsPage searchResultsPage = new SearchResultsPage(Naveen);
        homePage.searchComponent().performSearch(Search_Phrase);
        searchResultsPage.searchResultsItemsWithText(Search_Phrase);
        List<String> actualResult =searchResultsPage.searchResultsItemsText();
        List<String> expectedResult = searchResultsPage.searchResultsItemsWithText(Search_Phrase);
        Assertions.assertEquals(expectedResult, actualResult);
        System.out.println("Done all");
        /*WebElement search = Naveen.findElement(By.cssSelector("#twotabsearchtextbox"));
        WebElement search = Naveen.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        Assert.assertTrue(actualResult.stream().allMatch(item->item.contains(Search)));*/

    }

    @AfterAll
    public static void tearDown(){Naveen.close();}
}
