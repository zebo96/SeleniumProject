package com.test.etsy.tests;

import com.test.etsy.pages.EtsyPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EtsyPageTest extends EtsyTestBase {
    @Parameters({"searchName", "word1", "word2", "word3"})
    @Test
    public void validateSearchBarFunctionality(String searchName, String word1, String word2, String word3) throws InterruptedException {
        EtsyPage etsyPage=new EtsyPage(driver);
        etsyPage.searchBoxFunctionality(searchName);
        etsyPage.SearchResults(word1,word2,word3);

    }
}
