package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebPage {

    private WebDriver Naveen;

    protected WebPage(WebDriver Naveen){
        this.Naveen=Naveen;
    }

    protected List<WebElement> findElements(By Selector){
        return Naveen.findElements(Selector);
    }

    protected WebElement findElement(By Selector){
        return Naveen.findElement(Selector);
    }

}
