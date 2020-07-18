package androiddriverinitialization;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import java.net.URL;

public class StartStopAppiumServer {

  public URL startAppiumServer() {
    AppiumDriverLocalService driverLocalService = AppiumDriverLocalService
        .buildService(new AppiumServiceBuilder());
    driverLocalService.start();
    return driverLocalService.getUrl();
  }
  public void stopAppiumServer(){

  }

}
