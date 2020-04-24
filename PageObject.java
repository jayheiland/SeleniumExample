package com.WolframChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class PageObject {
    protected WebDriver driver;

    protected Integer defaultTimeout = 20;

    public PageObject(WebDriver driver){
        this.driver = driver;
    }

    public void goToURL(String url){
        driver.get(url);
    }

    public void waitUntilElementVisible(By by, Integer timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void setImplicitWait(Integer seconds){
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public void waitUntilElementCount(By by, Integer desiredCount, Integer timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                int elementCount = driver.findElements(by).size();
                if (elementCount >= desiredCount)
                    return true;
                else
                    return false;
            }
        });
    }

    public void switchTab(Integer index){

    }

    public Integer getElementCount(By by){
        return driver.findElements(by).size();
    }

    public Boolean isElementVisible(By by){
        try{
            waitUntilElementVisible(by, defaultTimeout);
        }
        catch (NoSuchElementException e){
            return false;
        }
        return true;
    }
}