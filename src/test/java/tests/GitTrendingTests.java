package tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.GitTrendingPage;

public class GitTrendingTests extends BaseSuite {

  private static final Logger log = LoggerFactory.getLogger(GitTrendingTests.class);

  String thirdRepoOwnerName;
  String thirdRepoName;
  String thirdRepoDescription;
  String thirdRepoLanguage;
  String thirdRepoStarCounts;
  String thirdRepoForkCounts;

  @BeforeClass
  public void selectSortByStars() {
    GitTrendingPage gitTrendingPage = new GitTrendingPage(driver);
    gitTrendingPage.clickOnOverFlowMenu();
    gitTrendingPage.clickOnSortByStarsOption();
  }

  @Test(priority = 1)
  public void expandAndStoreThirdItem() {
    GitTrendingPage gitTrendingPage = new GitTrendingPage(driver);
    gitTrendingPage.clickOnThirdElement();
    thirdRepoOwnerName = gitTrendingPage.getThirdRepoOwnerName();
    thirdRepoName = gitTrendingPage.getThirdRepoName();
    thirdRepoDescription = gitTrendingPage.getRepoDescription();
    thirdRepoLanguage = gitTrendingPage.getRepoLanguage();
    thirdRepoStarCounts = gitTrendingPage.getStarsCount();
    thirdRepoForkCounts = gitTrendingPage.getForkCount();
  }

  @Test(priority = 2)
  public void collapseThirdItem() {
    GitTrendingPage gitTrendingPage = new GitTrendingPage(driver);
    gitTrendingPage.clickOnThirdElement();
  }

  @Test(priority = 3)
  public void verifyElementGotCollapsed() {
    GitTrendingPage gitTrendingPage = new GitTrendingPage(driver);
    Assert
        .assertFalse(gitTrendingPage.checkRepoDescription(), "Repo desciption is still present");
    Assert.assertFalse(gitTrendingPage.checkRepoLanguage(), "Repo Language is still present");
    Assert.assertFalse(gitTrendingPage.checkStarsCount(), "Repo star count is still present");
    Assert.assertFalse(gitTrendingPage.checkForkCount(), "Repo count is still present");
    System.out.println("Third element got collapsed");
  }

  @Test(priority = 4)
  public void verifyRepoLanguageInPython() {
    GitTrendingPage gitTrendingPage = new GitTrendingPage(driver);
    gitTrendingPage.searchRepoInPythonLanguage();
    System.out.println("Python Repo Owner Name - " + gitTrendingPage.getThirdRepoOwnerName());
    System.out.println("Python Repo Name - " + gitTrendingPage.getThirdRepoName());
    System.out.println("Python Repo Description - " + gitTrendingPage.getRepoDescription());
    System.out.println("Python Repo Language - " + gitTrendingPage.getRepoLanguage());
    System.out.println("Python Repo Star Counts - " + gitTrendingPage.getStarsCount());
    System.out.println("Python Repo Fork Counts - " + gitTrendingPage.getForkCount());
  }

  @Test(priority = 5)
  public void printThirdRepoElements() {
    System.out.println("Third Repo Owner Name - " + thirdRepoOwnerName);
    System.out.println("Third Repo Name - " + thirdRepoName);
    System.out.println("Third Repo Description - " + thirdRepoDescription);
    System.out.println("Third Repo Language - " + thirdRepoLanguage);
    System.out.println("Third Repo Star Counts - " + thirdRepoStarCounts);
    System.out.println("Third Repo Fork Counts - " + thirdRepoForkCounts);
  }

}
