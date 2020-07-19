package driverinitialization;

import driverinitializer.AppiumInitializer;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import java.io.File;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AndroidDriverInitialization implements AppiumInitializer {

  AppiumServerInitialization appiumServerInitialization = new AppiumServerInitialization();
  AppiumDriver<MobileElement> driver;

  @Override
  public AppiumDriver<MobileElement> startAppiumDriver() {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
    capabilities.setCapability(MobileCapabilityType.APP,
        System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
            + File.separator + "resources" + File.separator + "gitTrendingApp.apk");
    capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
    capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60 * 2);
    driver = new AndroidDriver<>(
        appiumServerInitialization.startAppiumServer(), capabilities);
    return driver;
  }
}