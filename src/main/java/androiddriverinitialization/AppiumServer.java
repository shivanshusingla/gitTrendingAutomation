package androiddriverinitialization;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import java.net.URL;

public class AppiumServer {

  AppiumDriverLocalService driverLocalService = AppiumDriverLocalService
      .buildService(new AppiumServiceBuilder());

  public URL startAppiumServer() {
    driverLocalService.start();
    return driverLocalService.getUrl();
  }

  public void stopAppiumServer() {
    driverLocalService.stop();
  }

}
