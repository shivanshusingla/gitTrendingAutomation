package pages;

import Wrappers.WrapperMethods;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import java.util.List;

public class GitTrendingPage extends CommonPage {

  @AndroidFindBy(id = "ivOptions")
  private AndroidElement optionsMenu;

  @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'title') and contains(@text,'Sort by stars')]")
  private AndroidElement sortByStarsOption;

  @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvRepositoryOwnerName')]")
  private List<AndroidElement> repoOwnerNames;

  @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvRepositoryName')]")
  private List<AndroidElement> repoNames;

  @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvDescription')]")
  private AndroidElement repoDescription;

  @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvLanguage')]")
  private AndroidElement repoLanguage;

  @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvForks')]")
  private AndroidElement repoStarsCount;

  @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvStars')]")
  private AndroidElement repoForksCount;

  public GitTrendingPage(
      AppiumDriver<? extends MobileElement> driver) {
    super(driver);
  }

  public void clickOnOverFlowMenu() {
    WrapperMethods.click(optionsMenu);
  }

  public void clickOnSortByStarsOption() {
    WrapperMethods.click(sortByStarsOption);
  }

  public void clickOnThirdElement() {
    WrapperMethods.click(repoOwnerNames.get(2));
  }

  public String getThirdRepoOwnerName() {
    return WrapperMethods.getText(repoOwnerNames.get(2));
  }

  public String getThirdRepoName() {
    return WrapperMethods.getText(repoNames.get(2));
  }

  public String getRepoDescription() {
    return WrapperMethods.getText(repoDescription);
  }

  public boolean checkRepoDescription() {
    return WrapperMethods.verifyPresenceOfElement(repoDescription);
  }

  public String getRepoLanguage() {
    return WrapperMethods.getText(repoLanguage);
  }

  public boolean checkRepoLanguage() {
    return WrapperMethods.verifyPresenceOfElement(repoLanguage);
  }

  public String getStarsCount() {
    return WrapperMethods.getText(repoStarsCount);
  }

  public boolean checkStarsCount() {
    return WrapperMethods.verifyPresenceOfElement(repoStarsCount);
  }

  public String getForkCount() {
    return WrapperMethods.getText(repoForksCount);
  }

  public boolean checkForkCount() {
    return WrapperMethods.verifyPresenceOfElement(repoForksCount);
  }

  public void searchRepoInPythonLanguage() {
    int i = 0;
    while (!WrapperMethods.getText(repoLanguage).equalsIgnoreCase("Python") && i < repoOwnerNames
        .size()) {
      WrapperMethods.click(repoOwnerNames.get(i));
      i++;
    }
    if (!WrapperMethods.getText(repoLanguage).equalsIgnoreCase("Python")) {
      WrapperMethods.swipe(1, driver);
      searchRepoInPythonLanguage();
    } else {
      return;
    }
  }
}
