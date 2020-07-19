package tests;

import driverinitialization.AndroidDriverInitialization;
import driverinitialization.AppiumServerInitialization;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseSuite {

  AndroidDriverInitialization driverInitialization = new AndroidDriverInitialization();
  AppiumServerInitialization appiumServerInitialization = new AppiumServerInitialization();
  AppiumDriver<MobileElement> driver;

  @BeforeSuite(description = "1. Launch attached gitTrending application and Start Appium Driver")
  public void startAppiumDriver() {
    driver = driverInitialization.startAppiumDriver();
  }

  @AfterSuite(description = "Stop Appium Server and Driver", alwaysRun = true)
  public void stopAppiumDriver() {
    driver.quit();
    Runtime.getRuntime().addShutdownHook(new Thread() {
                                           public void run() {
                                             appiumServerInitialization.stopAppiumServer();
                                           }
                                         }
    );
  }
}
