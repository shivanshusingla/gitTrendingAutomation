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

}
