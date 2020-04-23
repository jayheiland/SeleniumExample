package com.WolframChallenge;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import java.sql.Driver;

public class TestSuite {
    DriverHandler masterDriver = new DriverHandler();

    @Test
    public void searchWolframAlpha_openWolframCloudNotebookAndExecute() {
        WolframAlpha_LandingPage landingPage = new WolframAlpha_LandingPage(masterDriver.getDriver());
        WolframAlpha_SearchResultsPage resultsPage = landingPage.getSearchResults("2+2");
        WolframCloud_Notebook notebookPage = resultsPage.goToComputableNotebook();
        notebookPage.executeCell(0);
        Assert.assertEquals(notebookPage.getCellContent(2, 3), "4");
    }

    @AfterSuite
    public void shutdown() throws InterruptedException{
        Thread.sleep(4000);
        masterDriver.quit();
    }
}
