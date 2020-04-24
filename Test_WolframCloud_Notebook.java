package com.WolframChallenge;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.sql.Driver;

public class Test_WolframCloud_Notebook {

    @Test
    public void searchWolframAlpha_openWolframCloudNotebookAndExecuteAllCellsOnce() {
        SoftAssert softAssert = new SoftAssert();
        DriverHandler masterDriver = new DriverHandler();
        WolframAlpha_LandingPage landingPage = new WolframAlpha_LandingPage(masterDriver.getDriver());
        WolframAlpha_SearchResultsPage resultsPage = landingPage.getSearchResults("2+2");
        WolframCloud_Notebook notebookPage = resultsPage.goToComputableNotebook(0);
        notebookPage.executeCell(0);
        softAssert.assertEquals(notebookPage.getCellContent(1, 3), "4", "1");
        notebookPage.executeCell(1);
        softAssert.assertEquals(notebookPage.getCellContent(3, 4), "four", "2");
        softAssert.assertEquals(notebookPage.getCellCount(), (Integer)4, "3");
        shutdown(masterDriver);
        softAssert.assertAll();
    }

    @Test
    public void searchWolframAlpha_openWolframCloudNotebookAndExecuteAllCellsMultipleTimes() {
        SoftAssert softAssert = new SoftAssert();
        DriverHandler masterDriver = new DriverHandler();
        WolframAlpha_LandingPage landingPage = new WolframAlpha_LandingPage(masterDriver.getDriver());
        WolframAlpha_SearchResultsPage resultsPage = landingPage.getSearchResults("2+2");
        WolframCloud_Notebook notebookPage = resultsPage.goToComputableNotebook(0);
        for(int idx = 0; idx < 10; idx++) {
            notebookPage.executeCell(0);
        }
        softAssert.assertEquals(notebookPage.getCellContent(1, 3), "4", "1");
        for(int idx = 0; idx < 10; idx++) {
            notebookPage.executeCell(1);
        }
        softAssert.assertEquals(notebookPage.getCellContent(3, 4), "four", "2");
        softAssert.assertEquals(notebookPage.getCellCount(), (Integer)4, "3");
        shutdown(masterDriver);
        softAssert.assertAll();
    }

    @Test
    public void searchWolframAlpha_openWolframCloudNotebookAndVerifyAutoGeneratedCells(){
        SoftAssert softAssert = new SoftAssert();
        DriverHandler masterDriver = new DriverHandler();
        WolframAlpha_LandingPage landingPage = new WolframAlpha_LandingPage(masterDriver.getDriver());
        WolframAlpha_SearchResultsPage resultsPage = landingPage.getSearchResults("2+2");
        WolframCloud_Notebook notebookPage = resultsPage.goToComputableNotebook(0);
        softAssert.assertEquals(notebookPage.getCellContent(0, 2), "2+2 ", "1");
        softAssert.assertEquals(notebookPage.getCellContent(1, 2), "IntegerName[4,\"Words\"] ", "2");
        shutdown(masterDriver);
        softAssert.assertAll();
    }

    /*@Test
    public void searchWolframAlpha_openWolframCloudAndAccessEducationalLinks() {
        DriverHandler masterDriver = new DriverHandler();
        WolframAlpha_LandingPage landingPage = new WolframAlpha_LandingPage(masterDriver.getDriver());
        WolframAlpha_SearchResultsPage resultsPage = landingPage.getSearchResults("2+2");
        WolframCloud_Notebook notebookPage = resultsPage.goToComputableNotebook(0);
        Wolfram_FastIntroduction intro = notebookPage.goToFastIntroduction();
        shutdown(masterDriver);
    }*/

    public void shutdown(DriverHandler driver) {
        driver.quit();
    }
}
