package config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import static config.Browser_Constants.CONFIG_FILE_PATH;

public class ConfigFileReader {
    public static Properties prop = new Properties();
    public static void readPropertiesFile(){

        try {
            InputStream input = new FileInputStream(CONFIG_FILE_PATH);
            prop.load(input);
//            GlobalParameter.Setting.ClientSecret = prop.getProperty("ClientSecret");
//            GlobalParameter.Setting.ClientID= prop.getProperty("ClientID");
//            GlobalParameter.Setting.BusinessUnit = prop.getProperty("BusinessUnit");
//            GlobalParameter.Setting.AuthBase_URI_Sandbox = prop.getProperty("Auth_Base_URI_Sandbox");
//            GlobalParameter.Setting.RESTBase_URI_Sandbox= prop.getProperty("REST_Base_URI_Sandbox");
//            GlobalParameter.Setting.MID = Integer.parseInt(prop.getProperty("MID"));
//            GlobalParameter.Setting.AutomationScope = prop.getProperty("AutomationScope");
            GlobalParameter.Setting.Browser = prop.getProperty("Browser");
//            GlobalParameter.Setting.UserName = prop.getProperty("UserName");
//            GlobalParameter.Setting.Password = prop.getProperty("Password");
//            GlobalParameter.Setting.SFMC_URL = prop.getProperty("SFMC_URL");


        } catch (Exception e) {            e.printStackTrace();
        }

    }

}
