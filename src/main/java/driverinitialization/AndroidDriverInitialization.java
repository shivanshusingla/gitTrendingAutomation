package driverinitialization;

import constants.AndroidDriverConstants;
import driverinitializer.AppiumInitializer;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AndroidDriverInitialization implements AppiumInitializer {

  AppiumServerInitialization appiumServerInitialization = new AppiumServerInitialization();
  AppiumDriver<MobileElement> driver;

  @Override
  public AppiumDriver<MobileElement> startAppiumDriver() {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, AndroidDriverConstants.ANDROID);
    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, AndroidDriverConstants.ANDROID);
    capabilities
        .setCapability(MobileCapabilityType.APP, AndroidDriverConstants.GIT_TRENDING_APK_PATH);
    capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
    capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,
        AndroidDriverConstants.NEW_COMMAND_TIMEOUT);
    driver = new AndroidDriver<>(
        appiumServerInitialization.startAppiumServer(), capabilities);
    return driver;
  }
}
