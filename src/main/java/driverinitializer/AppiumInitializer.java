package driverinitializer;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public interface AppiumInitializer {

  AppiumDriver<MobileElement> startAppiumDriver();

}
