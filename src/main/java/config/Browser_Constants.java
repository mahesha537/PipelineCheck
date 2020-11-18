package config;

import Util.JavaUtil;

public class Browser_Constants {

    //Config file
    public static final String CONFIG_FILE_PATH = System.getProperty("user.dir") + "\\src\\main\\java\\config\\config.properties";

    //Webdriver
    public static final String CHROME_DRIVER = "webdriver.chrome.driver";
    public static final String CHROME_DRIVER_PATH = System.getProperty("user.dir") + "\\src\\main\\resources\\browserDrivers\\chromedriver.exe";
    public static final String FIREFOX_DRIVER = "webdriver.gecko.driver";
    public static final String FIREFOX_DRIVER_PATH = System.getProperty("user.dir") + "\\src\\main\\resources\\browserDrivers\\geckodriver.exe";

    //SFMC - CMT
    public static final String SFMC_FRAME = "canvas-b2ca1f50-3cc4-4fd7-a3a3-88bf09fb59fa";

    //Timeouts
    public static final long MIN_TIME_OUT = 15; //10 sec
    public static final long AVG_TIME_OUT = 40; //40 sec
    public static final long MAX_TIME_OUT = 60; //60 sec
    public static final long LATENCY_TIME_OUT = 90000; //millis

    //Failed Screenshot
    public static final String SCREENSHOT_FOLDERPATH = System.getProperty("user.dir") + "\\target\\screenshot\\";
    public static final String SCREENSHOT_FOLDERNAME = "ScreenShot_" + JavaUtil.getUniqueStamp();

}
