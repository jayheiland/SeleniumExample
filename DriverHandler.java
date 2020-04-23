package com.WolframChallenge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverHandler {
    public WebDriver driver;
    public DriverHandler(){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\munch\\IdeaProjects\\WolframChallenge\\lib\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void quit(){
        driver.quit();
    }
}
