package com.WolframChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class WolframAlpha_SearchResultsPage extends PageObject{
    final public By locator_PlainTextButton = By.xpath("//button/span/span[contains(text(),'Plain Text')]");
    final public By locator_OpenInNotebookButton = By.cssSelector("button[class='_10um4 _2XRvV _1BfJ4']");
    final public By locator_ResultCell = By.className("_2z545");
    final public By locator_pageIdentifier = By.id("__next");

    //plain text interface locators
    final public By locator_PlainTextInterface_Header = By.xpath("//span[contains(text(), 'Wolfram|Alpha Copyable Plain Text')]");
    final public By getLocator_PlainTextInterface_CloseButton = By.cssSelector("button[class='_10um4 _3sfTM _7irlU']");

    public WolframAlpha_SearchResultsPage(WebDriver driver){
        super(driver);
        waitUntilElementVisible(locator_pageIdentifier, defaultTimeout);
    }

    public WolframCloud_Notebook goToComputableNotebook(Integer cellIndex) {
        openPlainTextOptionForCell(cellIndex);
        driver.findElement(locator_OpenInNotebookButton).click();
        WolframCloud_Notebook notebook = new WolframCloud_Notebook(this.driver);
        return notebook;
    }

    public void openPlainTextOptionForCell(Integer cellIndex){
        waitUntilElementCount(locator_ResultCell, cellIndex + 3, defaultTimeout);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElements(locator_ResultCell).get(cellIndex)).build().perform();
        waitUntilElementVisible(locator_PlainTextButton, defaultTimeout);
        actions.moveToElement(driver.findElements(locator_PlainTextButton).get(0)).click().build().perform();
    }

    public void closePlainTextInterface(){
        driver.findElement(getLocator_PlainTextInterface_CloseButton).click();
    }
}