package com.WolframChallenge;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Test_WolframAlpha_SearchResultsPage {
    @Test
    public void testResultCell_plainTextButtonsNotPresentByDefault(){
        SoftAssert softAssert = new SoftAssert();
        DriverHandler masterDriver = new DriverHandler();
        WolframAlpha_SearchResultsPage resultsPage = new WolframAlpha_LandingPage(masterDriver.getDriver()).getSearchResults("2+2");
        softAssert.assertEquals(resultsPage.getElementCount(resultsPage.locator_PlainTextButton), (Integer)0);
        shutdown(masterDriver);
        softAssert.assertAll();
    }

    @Test
    public void testResultCell_openAndClosePlainTextInterface(){
        SoftAssert softAssert = new SoftAssert();
        DriverHandler masterDriver = new DriverHandler();
        WolframAlpha_SearchResultsPage resultsPage = new WolframAlpha_LandingPage(masterDriver.getDriver()).getSearchResults("2+2");
        resultsPage.openPlainTextOptionForCell(0);
        softAssert.assertEquals(resultsPage.getElementCount(resultsPage.locator_PlainTextInterface_Header), (Integer)1);
        resultsPage.closePlainTextInterface();
        softAssert.assertEquals(resultsPage.getElementCount(resultsPage.locator_PlainTextInterface_Header), (Integer)0);
        shutdown(masterDriver);
        softAssert.assertAll();
    }

    @Test
    public void testResultCell_plainTextInterfaceNotPresentByDefault(){
        SoftAssert softAssert = new SoftAssert();
        DriverHandler masterDriver = new DriverHandler();
        WolframAlpha_SearchResultsPage resultsPage = new WolframAlpha_LandingPage(masterDriver.getDriver()).getSearchResults("2+2");
        softAssert.assertEquals(resultsPage.getElementCount(resultsPage.locator_PlainTextInterface_Header), (Integer)0);
        shutdown(masterDriver);
        softAssert.assertAll();
    }

    public void shutdown(DriverHandler driver) {
        driver.quit();
    }
}
