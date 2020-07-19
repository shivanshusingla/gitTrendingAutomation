package driverinitialization;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import java.net.URL;

public class AppiumServerInitialization {

  AppiumDriverLocalService driverLocalService = AppiumDriverLocalService
      .buildService(new AppiumServiceBuilder().usingAnyFreePort());

  public URL startAppiumServer() {
    driverLocalService.start();
    System.out.println("--------- Appium Server Started ----------");
    driverLocalService.clearOutPutStreams();
    return driverLocalService.getUrl();
  }

  public void stopAppiumServer() {
    driverLocalService.stop();
    System.out.println("--------- Appium Server Closed ----------");
  }
}
