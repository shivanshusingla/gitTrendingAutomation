package tests;

import androiddriverinitialization.AndroidDriverInitialization;
import androiddriverinitialization.StartStopAppiumServer;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseSuite {

  AndroidDriverInitialization driverInitialization = new AndroidDriverInitialization();
  StartStopAppiumServer appiumServer = new StartStopAppiumServer();
  AppiumDriver<MobileElement> driver;

  @BeforeSuite
  public void startAppiumDriver() {
    driver = driverInitialization.startAppiumDriver();
  }

  @AfterSuite(alwaysRun = true)
  public void stopAppiumDriver() {
    appiumServer.stopAppiumServer();
  }

}
