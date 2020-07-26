package constants;

import java.io.File;

public interface AndroidDriverConstants {

  String ANDROID = "Android";
  String GIT_TRENDING_APK_PATH =
      System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
          + File.separator + "resources" + File.separator + "gitTrendingApp.apk";
  int NEW_COMMAND_TIMEOUT = 60 * 2;
}
