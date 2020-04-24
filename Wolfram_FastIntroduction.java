package com.WolframChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Wolfram_FastIntroduction extends PageObject{
    public Wolfram_FastIntroduction(WebDriver driver){
        super(driver);
        waitUntilElementVisible(By.id("fast-introduction"), defaultTimeout);
    }
}
