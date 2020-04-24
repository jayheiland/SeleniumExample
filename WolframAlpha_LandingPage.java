package com.WolframChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WolframAlpha_LandingPage extends PageObject {
    final public By locator_PageIdentifier = By.className("_2hZZZ");
    final public By locator_SearchField = By.className("_2oXzi");
    final public By locator_SearchButton = By.cssSelector("button[class='_10um4 _2DVTv HuMWM']");
    final public By locator_InstantMathResult = By.className("_3bju9");

    public WolframAlpha_LandingPage(WebDriver driver){
        super(driver);
        goToURL("https://www.wolframalpha.com");
        waitUntilElementVisible(locator_PageIdentifier, defaultTimeout);
    }

    public WolframAlpha_SearchResultsPage getSearchResults(String search){
        enterNewSearchString(search);
        return clickSubmitSearchButton();
    }

    public void enterNewSearchString(String search){
        WebElement searchField = driver.findElement(locator_SearchField);
        searchField.clear();
        searchField.sendKeys(search);
    }

    public WolframAlpha_SearchResultsPage clickSubmitSearchButton(){
        driver.findElement(locator_SearchButton).click();
        WolframAlpha_SearchResultsPage resultsPage = new WolframAlpha_SearchResultsPage(driver);
        return resultsPage;
    }

    public WolframAlpha_SearchResultsPage pressEnterInSearchField(){
        driver.findElement(locator_SearchField).sendKeys(Keys.ENTER);
        WolframAlpha_SearchResultsPage resultsPage = new WolframAlpha_SearchResultsPage(driver);
        return resultsPage;
    }

    public String getSearchFieldContents(){
        return driver.findElement(locator_SearchField).getAttribute("value");
    }

    public String getInstantMathResult(){
        waitUntilElementVisible(locator_InstantMathResult, defaultTimeout);
        return driver.findElement(locator_InstantMathResult).getText();
    }
}
