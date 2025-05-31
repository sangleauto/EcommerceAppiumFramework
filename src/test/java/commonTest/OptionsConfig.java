package commonTest;

import io.appium.java_client.android.options.UiAutomator2Options;

import java.util.HashMap;
import java.util.Map;

public class OptionsConfig {
    private static final String APP_PACKAGE = "com.androidsample.generalstore";
    private static final String APP_ACTIVITY = "com.androidsample.generalstore.SplashActivity";
    private static final Map<String, UiAutomator2Options> deviceOptions = new HashMap<>();

    static {
        UiAutomator2Options options1 = new UiAutomator2Options().setUdid("emulator-5554").setDeviceName("Pixel_6a").setAppPackage(APP_PACKAGE).setAppActivity(APP_ACTIVITY);
        deviceOptions.put("emulator-5554", options1);

        UiAutomator2Options options2 = new UiAutomator2Options().setUdid("emulator-5556").setDeviceName("Pixel_8").setAppPackage(APP_PACKAGE).setAppActivity(APP_ACTIVITY);
        deviceOptions.put("emulator-5556", options2);
    }

    public static UiAutomator2Options getOptions(String udid){
        return deviceOptions.get(udid);
    }
}
