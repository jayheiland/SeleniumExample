package com.WolframChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WolframCloud_Notebook extends PageObject{
    private Integer unimportantPrecedingCellContentsCount = 5;

    final public By locator_CellContent = By.xpath("//div[@class='cell']/div[@class='cell-wrapper']/div[@class='cell-content']/div/div");
    final public By locator_CellPlayButton = By.cssSelector("div[class='TooltipBoxContainer pa TooltipBoxContainer']");
    final public By locator_FastIntroLink = By.className("_3QAPQ7FIKVSAE722rX66Wa");
    final public By locator_pageIdentifier = By.id("doc");

    public WolframCloud_Notebook(WebDriver driver){
        super(driver);
        waitUntilElementVisible(locator_pageIdentifier, defaultTimeout);
    }

    public void executeCell(Integer index){
        waitUntilElementVisible(locator_CellPlayButton, defaultTimeout);
        List<WebElement> cellPlayButtons = driver.findElements(locator_CellPlayButton);
        cellPlayButtons.get(index).click();

    }

    public String getCellContent(Integer index, Integer waitForCellContentCount){
        waitUntilElementCount(locator_CellContent,waitForCellContentCount + unimportantPrecedingCellContentsCount, defaultTimeout);
        List<WebElement> testCellContents = driver.findElements(locator_CellContent);
        return testCellContents.get((index + 1) + (unimportantPrecedingCellContentsCount - 1)).getText().replace("\n", "");
    }

    public Integer getCellCount(){
        return getElementCount(locator_CellContent) - unimportantPrecedingCellContentsCount;
    }

    public Wolfram_FastIntroduction goToFastIntroduction(){
        waitUntilElementVisible(locator_FastIntroLink, defaultTimeout);
        driver.findElement(locator_FastIntroLink).click();
        switchTabRight(3);
        Wolfram_FastIntroduction intro = new Wolfram_FastIntroduction(driver);
        return intro;
    }
}
