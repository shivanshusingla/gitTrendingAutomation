package Wrappers;

import io.appium.java_client.android.AndroidElement;

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

}
