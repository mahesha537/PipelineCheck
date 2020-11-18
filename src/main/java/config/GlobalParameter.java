package config;

import io.cucumber.java.Scenario;

public  class GlobalParameter {
    public static class Setting{
        public static String ClientSecret;
        public static String ClientID;
        public static String BusinessUnit;
        public static int MID;
        public static String AuthBase_URI_Sandbox;
        public static String RESTBase_URI_Sandbox;
        public static String AutomationScope;
        public static String Browser;
        public static String UserName;
        public static String Password;
        public static String SFMC_URL;
//        Added for Screenshots
        public static int SCount;
        public static String ScenarioName;
        public static Scenario ScenarioObj;
        public static String ReportFolder;

    }

}
