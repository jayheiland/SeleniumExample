package com.WolframChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WolframCloud_Notebook extends PageObject{
    private Integer unimportantPrecedingCellContentsCount = 5;

    public WolframCloud_Notebook(WebDriver driver){
        super(driver);
    }

    public void executeCell(Integer index){
        waitUntilElementVisible(By.cssSelector("div[class='TooltipBoxContainer pa TooltipBoxContainer']"), 15);
        List<WebElement> cellPlayButtons = driver.findElements(By.cssSelector("div[class='TooltipBoxContainer pa TooltipBoxContainer']"));
        cellPlayButtons.get(index).click();

    }

    public String getCellContent(Integer index, Integer waitForCellCount){
        waitUntilElementCount(By.xpath("//div[@class='cell']/div[@class='cell-wrapper']/div[@class='cell-content']/div/div"),waitForCellCount + unimportantPrecedingCellContentsCount, 20);
        List<WebElement> testCells = driver.findElements(By.xpath("//div[@class='cell']/div[@class='cell-wrapper']/div[@class='cell-content']/div/div"));
        System.out.println("Number of desired things: " + testCells.size());
        List<WebElement> cellOutputs = driver.findElements(By.className("cell"));
        for (WebElement we : testCells) {
            System.out.println(we.getText());
            System.out.println("--------------------------------------------------------");
        }
        return testCells.get(index + unimportantPrecedingCellContentsCount - 1).getText();
    }
}
