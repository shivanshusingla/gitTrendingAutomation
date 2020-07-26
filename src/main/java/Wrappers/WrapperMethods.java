package Wrappers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

public class WrapperMethods {

  public static boolean verifyPresenceOfElement(AndroidElement androidElement) {
    try {
      return androidElement.isDisplayed();
    } catch (Exception e) {
      return false;
    }
  }

  public static String getText(AndroidElement androidElement) {
    String text;
    try {
      text = androidElement.getText();
    } catch (Exception e) {
      return "";
    }
    return text;
  }

  public static void click(AndroidElement androidElement) {
    try {
      androidElement.click();
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return;
    }
  }

  public static void swipe(int noOfTimes, AppiumDriver<MobileElement> driver) {
    while (noOfTimes > 0) {
      Dimension size = driver.manage().window().getSize();
      int anchor = (int) (size.width * 0.50);
      int startPoint = (int) (size.height * 0.60);
      int endPoint = (int) (size.height * 0.20);

      new TouchAction(driver)
          .longPress(PointOption.point(anchor, startPoint))
          .moveTo(PointOption.point(anchor, endPoint))
          .release().perform();
      noOfTimes--;
    }
  }
}
