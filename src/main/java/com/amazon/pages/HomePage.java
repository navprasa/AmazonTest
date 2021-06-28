package com.amazon.pages;

import components.impl.SearchComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends WebPage {

    public HomePage(WebDriver Naveen) {
        super(Naveen);
    }
    private static final By SEARCH_COMPONENT_SELECTOR = By.xpath("//input[@id='twotabsearchtextbox']");

    public SearchComponent searchComponent(){
        return new SearchComponent(findElement(SEARCH_COMPONENT_SELECTOR));
    }



}
