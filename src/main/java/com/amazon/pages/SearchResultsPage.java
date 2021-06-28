package com.amazon.pages;

import components.WebComponent;
import components.impl.SearchResultItemComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultsPage extends WebPage{
    public SearchResultsPage(WebDriver Naveen) {
        super(Naveen);
    }

    private static final By SEARCH_RESULTS_ITEM_SELECTOR = By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");

    private List<SearchResultItemComponents> searchResultItems(){
        return findElements(SEARCH_RESULTS_ITEM_SELECTOR).stream()
                .map(SearchResultItemComponents::new)
                .collect(Collectors.toList());
    }

    public List<String> searchResultsItemsText(){
        return searchResultItems().stream()
                .map(WebComponent::getText)
                .collect(Collectors.toList());

    }

    public List<String> searchResultsItemsWithText(String searchPhrase) {
        return searchResultItems().stream()
                .filter(item->item.containsSearchPhrase(searchPhrase))
                .map(WebComponent::getText)
                .collect(Collectors.toList());

    }
}
