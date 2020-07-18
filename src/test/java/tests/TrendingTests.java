package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.TrendingPage;

public class TrendingTests extends BaseSuite {

  TrendingPage trendingPage = new TrendingPage(driver);

  @BeforeClass
  public void selectSortByStars() {
    trendingPage.clickOnOverFlowMenu();
    trendingPage.clickOnSortByStarsOption();
  }


}
