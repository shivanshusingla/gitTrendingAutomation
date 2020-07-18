package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class TrendingPage extends BasePage {

  @AndroidFindBy(id = "ivOptions")
  private AndroidElement optionsMenu;

  @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'title') and contains(@text,'Sort by stars')]")
  private AndroidElement sortByStarsOption;

  @AndroidFindBy(xpath = "(//android.widget.TextView[contains(@resource-id,'tvRepositoryOwnerName')])[3]")
  private AndroidElement thirdRepoOwnerName;

  @AndroidFindBy(xpath = "(//android.widget.TextView[contains(@resource-id,'tvRepositoryName')])[3]")
  private AndroidElement thirdRepoName;

  @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvDescription')]")
  private AndroidElement thirdRepoDescription;

  @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvLanguage')]")
  private AndroidElement thirdRepoLanguage;

  @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvForks')]")
  private AndroidElement thirdRepoStarsCount;

  @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'tvStars')]")
  private AndroidElement thirdRepoForksCount;

  public TrendingPage(
      AppiumDriver<? extends MobileElement> driver) {
    super(driver);
  }

  public void clickOnOverFlowMenu() {
    optionsMenu.click();
  }

  public void clickOnSortByStarsOption() {
    sortByStarsOption.click();
  }

  public void clickOnThirdElement() {
    thirdRepoOwnerName.click();
  }

  public String getThirdRepoOwnerName() {
    return thirdRepoOwnerName.getText();
  }

  public String getThirdRepoName() {
    return thirdRepoName.getText();
  }

  public String getThirdRepoDescription() {
    return thirdRepoDescription.getText();
  }

  public boolean checkThirdRepoDescription() {
    try {
      return thirdRepoDescription.isDisplayed();
    } catch (Exception e) {
      return false;
    }
  }

  public String getThirdRepoLanguage() {
    String thirdRepoLanguageString = null;
    try {
      thirdRepoLanguageString = thirdRepoLanguage.getText();
    } catch (Exception e) {
      return "!!!!Language is not Empty!!!!";
    }
    return thirdRepoLanguageString;
  }

  public boolean checkThirdRepoLanguage() {
    try {
      return thirdRepoLanguage.isDisplayed();
    } catch (Exception e) {
      return false;
    }
  }

  public String getThirdStarsCount() {
    return thirdRepoStarsCount.getText();
  }

  public boolean checkThirdStarsCount() {
    try {
      return thirdRepoStarsCount.isDisplayed();
    } catch (Exception e) {
      return false;
    }
  }

  public String getThirdForkCount() {
    return thirdRepoForksCount.getText();
  }

  public boolean checkThirdForkCount() {
    try {
      return thirdRepoForksCount.isDisplayed();
    } catch (Exception e) {
      return false;
    }
  }

}
