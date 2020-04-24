package com.WolframChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WolframAlpha_LandingPage extends PageObject {
    public WolframAlpha_LandingPage(WebDriver driver){
        super(driver);
        goToURL("https://www.wolframalpha.com");
    }

    public WolframAlpha_SearchResultsPage getSearchResults(String search){
        enterNewSearchString(search);
        return clickSubmitSearchButton();
    }

    public void enterNewSearchString(String search){
        WebElement searchField = driver.findElement(By.className("_2oXzi"));
        searchField.clear();
        searchField.sendKeys(search);
    }

    public WolframAlpha_SearchResultsPage clickSubmitSearchButton(){
        driver.findElement(By.cssSelector("button[class='_10um4 _2DVTv HuMWM']")).click();
        WolframAlpha_SearchResultsPage resultsPage = new WolframAlpha_SearchResultsPage(this.driver);
        return resultsPage;
    }

    public WolframAlpha_SearchResultsPage pressEnterInSearchField(){
        driver.findElement(By.className("_2oXzi")).sendKeys(Keys.ENTER);
        WolframAlpha_SearchResultsPage resultsPage = new WolframAlpha_SearchResultsPage(this.driver);
        return resultsPage;
    }

    public String getSearchFieldContents(){
        WebElement searchField = driver.findElement(By.className("_2oXzi"));
        return searchField.getAttribute("value");
    }

    public String getInstantMathResult(){
        waitUntilElementVisible(By.className("_3bju9"), defaultTimeout);
        return driver.findElement(By.className("_3bju9")).getText();
    }
}
