package components.impl;

import components.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchResultItemComponents extends WebComponent {

    private static final By TITLE_SELECTOR = By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");

    public SearchResultItemComponents(WebElement rootElement) {
        super(rootElement);
    }

    public boolean containsSearchPhrase(String searchPhrase){
        return containsSearchPhraseIgnoringCase(searchPhrase, TITLE_SELECTOR);
    }

    public boolean containsSearchPhraseIgnoringCase(String searchPhrase, By Selector){
        return findElement(Selector).getText().toLowerCase().contains(searchPhrase);
    }


}
