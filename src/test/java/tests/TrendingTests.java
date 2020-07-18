package tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.TrendingPage;

public class TrendingTests extends BaseSuite {

  private static final Logger log = LoggerFactory.getLogger(TrendingTests.class);

  String thirdRepoOwnerName;
  String thirdRepoName;
  String thirdRepoDescription;
  String thirdRepoLanguage;
  String thirdRepoStarCounts;
  String thirdRepoForkCounts;

  @BeforeClass
  public void selectSortByStars() {
    TrendingPage trendingPage = new TrendingPage(driver);
    trendingPage.clickOnOverFlowMenu();
    trendingPage.clickOnSortByStarsOption();
  }

  @Test(priority = 1)
  public void expandAndStoreThirdItem() {
    TrendingPage trendingPage = new TrendingPage(driver);
    trendingPage.clickOnThirdElement();
    thirdRepoOwnerName = trendingPage.getThirdRepoOwnerName();
    thirdRepoName = trendingPage.getThirdRepoName();
    thirdRepoDescription = trendingPage.getThirdRepoDescription();
    thirdRepoLanguage = trendingPage.getThirdRepoLanguage();
    thirdRepoStarCounts = trendingPage.getThirdStarsCount();
    thirdRepoForkCounts = trendingPage.getThirdForkCount();
  }

  @Test(priority = 2)
  public void collapseThirdItem() {
    TrendingPage trendingPage = new TrendingPage(driver);
    trendingPage.clickOnThirdElement();
  }

  @Test(priority = 3)
  public void verifyElementGotCollapsed() {
    TrendingPage trendingPage = new TrendingPage(driver);
    Assert
        .assertFalse(trendingPage.checkThirdRepoDescription(), "Repo desciption is still present");
    Assert.assertFalse(trendingPage.checkThirdRepoLanguage(), "Repo Language is still present");
    Assert.assertFalse(trendingPage.checkThirdStarsCount(), "Repo star count is still present");
    Assert.assertFalse(trendingPage.checkThirdForkCount(), "Repo count is still present");
    System.out.println("Third element got collapsed");
  }

  @Test(priority = 4)
  public void printThirdRepoElements() {
    System.out.println("Third Repo Owner Name - " + thirdRepoOwnerName);
    System.out.println("Third Repo Name - " + thirdRepoName);
    System.out.println("Third Repo Description - " + thirdRepoDescription);
    System.out.println("Third Repo Language - " + thirdRepoLanguage);
    System.out.println("Third Repo Star Counts - " + thirdRepoStarCounts);
    System.out.println("Third Repo Fork Counts - " + thirdRepoForkCounts);
  }

}
