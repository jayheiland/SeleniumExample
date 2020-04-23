package com.WolframChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WolframAlpha_LandingPage extends PageObject {
    public WolframAlpha_LandingPage(WebDriver driver){
        super(driver);
        goToURL("https://www.wolframalpha.com");
    }

    public WolframAlpha_SearchResultsPage getSearchResults(String search){
        enterNewSearchString(search);
        clickSubmitSearchButton();
        WolframAlpha_SearchResultsPage resultsPage = new WolframAlpha_SearchResultsPage(this.driver);
        return resultsPage;
    }

    public void enterNewSearchString(String search){
        WebElement searchField = driver.findElement(By.className("_2oXzi"));
        searchField.clear();
        searchField.sendKeys(search);
    }

    public void clickSubmitSearchButton(){
        driver.findElement(By.cssSelector("button[class='_10um4 _2DVTv HuMWM']")).click();
    }

    public String getInstantMathResult(){
        return driver.findElement(By.className("_3bju9")).getText();
    }
}
