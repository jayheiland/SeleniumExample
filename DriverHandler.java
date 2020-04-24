package com.WolframChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverHandler {
    public WebDriver driver;
    public DriverHandler(){
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\lib\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void quit(){
        driver.quit();
    }
}
