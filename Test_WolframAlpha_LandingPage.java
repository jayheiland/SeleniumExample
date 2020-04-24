package com.WolframChallenge;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.sql.Driver;

public class Test_WolframAlpha_LandingPage {
    @Test
    public void testSearchField_IsEditable() {
        SoftAssert softAssert = new SoftAssert();
        DriverHandler masterDriver = new DriverHandler();
        WolframAlpha_LandingPage landingPage = new WolframAlpha_LandingPage(masterDriver.getDriver());
        landingPage.enterNewSearchString("2+2");
        softAssert.assertEquals(landingPage.getSearchFieldContents(), "2+2");
        shutdown(masterDriver);
        softAssert.assertAll();
    }

    @Test
    public void testSearchField_InstantMathResultIsCorrect(){
        SoftAssert softAssert = new SoftAssert();
        DriverHandler masterDriver = new DriverHandler();
        WolframAlpha_LandingPage landingPage = new WolframAlpha_LandingPage(masterDriver.getDriver());
        landingPage.enterNewSearchString("2+2");
        softAssert.assertEquals(landingPage.getInstantMathResult(), "4");
        shutdown(masterDriver);
        softAssert.assertAll();
    }

    @Test
    public void testSearchField_SearchButtonGoesToResultsPage() {
        DriverHandler masterDriver = new DriverHandler();
        WolframAlpha_LandingPage landingPage = new WolframAlpha_LandingPage(masterDriver.getDriver());
        WolframAlpha_SearchResultsPage resultsPage = landingPage.getSearchResults("2+2");
        shutdown(masterDriver);
    }

    @Test
    public void testSearchField_EnterKeyPressGoesToResultsPage() {
        DriverHandler masterDriver = new DriverHandler();
        WolframAlpha_LandingPage landingPage = new WolframAlpha_LandingPage(masterDriver.getDriver());
        landingPage.enterNewSearchString("2+2");
        WolframAlpha_SearchResultsPage resultsPage = landingPage.pressEnterInSearchField();
        shutdown(masterDriver);
    }

    public void shutdown(DriverHandler driver) {
        driver.quit();
    }
}
