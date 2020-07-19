package tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.GitTrendingPage;

public class GitTrendingTests extends BaseSuite {

  String thirdRepoOwnerName;
  String thirdRepoName;
  String thirdRepoDescription;
  String thirdRepoLanguage;
  String thirdRepoStarCounts;
  String thirdRepoForkCounts;

  @BeforeClass(description = "2. Sort elements on basis of stars")
  public void selectSortByStars() {
    GitTrendingPage gitTrendingPage = new GitTrendingPage(driver);
    gitTrendingPage.clickOnOverFlowMenu();
    gitTrendingPage.clickOnSortByStarsOption();
  }

  @Test(description = "3. Click on the third element and save expanded item content in a variable", priority = 1)
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

  @Test(description = "4. Click on the same element to collapse it", priority = 2)
  public void collapseThirdItem() {
    GitTrendingPage gitTrendingPage = new GitTrendingPage(driver);
    gitTrendingPage.clickOnThirdElement();
  }

  @Test(description = "5. Verify element got collapsed", priority = 3)
  public void verifyElementGotCollapsed() {
    GitTrendingPage gitTrendingPage = new GitTrendingPage(driver);
    Assert
        .assertFalse(gitTrendingPage.checkRepoDescription(), "Repo desciption is still present");
    Assert.assertFalse(gitTrendingPage.checkRepoLanguage(), "Repo Language is still present");
    Assert.assertFalse(gitTrendingPage.checkStarsCount(), "Repo star count is still present");
    Assert.assertFalse(gitTrendingPage.checkForkCount(), "Repo count is still present");
    System.out.println("Third element got collapsed");
  }

  @Test(description = "6. Print the element(s) which source language is Python only.", priority = 4)
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

  @Test(description = "7. Print the third step variable.", priority = 5)
  public void printThirdRepoElements() {
    System.out.println("Third Repo Owner Name - " + thirdRepoOwnerName);
    System.out.println("Third Repo Name - " + thirdRepoName);
    System.out.println("Third Repo Description - " + thirdRepoDescription);
    System.out.println("Third Repo Language - " + thirdRepoLanguage);
    System.out.println("Third Repo Star Counts - " + thirdRepoStarCounts);
    System.out.println("Third Repo Fork Counts - " + thirdRepoForkCounts);
  }

}
