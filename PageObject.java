package com.WolframChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

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

    public void switchTabRight(Integer num){
        for(int idx = 0; idx < num; idx++) {
            driver.findElement(By.cssSelector("body")).sendKeys(Keys.chord(Keys.CONTROL, Keys.PAGE_DOWN));
        }
    }

    public void switchTabLeft(Integer num){
        for(int idx = 0; idx < num; idx++) {
            driver.findElement(By.cssSelector("body")).sendKeys(Keys.chord(Keys.CONTROL, Keys.PAGE_UP));
        }
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

    public Integer getElementCount(By by){
        return driver.findElements(by).size();
    }
}