package com.WolframChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class WolframAlpha_SearchResultsPage extends PageObject{
    public WolframAlpha_SearchResultsPage(WebDriver driver){
        super(driver);
    }

    public WolframCloud_Notebook goToComputableNotebook() {
        Actions actions = new Actions(driver);

        waitUntilElementVisible(By.className("_2z545"), 15);

        actions.moveToElement(driver.findElements(By.className("_2z545")).get(0)).build().perform();

        actions.moveToElement(driver.findElement(By.xpath("//button/span/span[contains(text(),'Plain Text')]"))).click().build().perform();
        driver.findElement(By.cssSelector("button[class='_10um4 _2XRvV _1BfJ4']")).click();
        WolframCloud_Notebook notebook = new WolframCloud_Notebook(this.driver);
        return notebook;
    }
}