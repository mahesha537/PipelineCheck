package stepDefinitions;

import Reports.customExtentReports;
import Util.JavaUtil;
import Util.ReUsableUtil;
import Utilities.ReportUtility;
import config.ConfigFileReader;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;

import static config.GlobalParameter.Setting.*;

public class Hooks {

    private static customExtentReports customextentReports;
    private static boolean isReporterRunning;

//    @Before
//    public void beforeScenario(Scenario scenario){
//        if(!isReporterRunning){
//            customextentReports = new customExtentReports("target\\cucumber-reports\\report.html");
//            isReporterRunning=true;
//        }
//    }
//
//    @After
//    public void afterScenario(Scenario scenario) throws IOException {
//        String scenarioFileName = "target\\cucumber-reports\\"+scenario.getName().replaceAll(" ","")+".jpeg";
//        if(scenario.isFailed()) {
//            ReportUtility.getScreenshot(scenarioFileName);
//        }
//        customextentReports.createTest(scenario,scenarioFileName);
//        customextentReports.writeToReport();
//        ReportUtility.quitDriver();
//    }
@After
public static void afterScenario (Scenario scenario) throws IOException {
    if (scenario.isFailed()) {
        check1Steps.getScreenshot();
    }
}
    @AfterStep
    public void afterSteps(){
        check1Steps.getScreenshot();
    }

    @Before
    public static void beforeScenario (Scenario scenario) {
        ScenarioObj = scenario;
        // Reporter.assignAuthor("CDM Automation Tester -- Mahesh");
        ScenarioName = scenario.getName().replaceAll(" ", "_");
        System.out.println("Taken Scenario Name from Before Annot successfully: "+ScenarioName);
        SCount = 0;
        ReportFolder = ScenarioName+ JavaUtil.getUniqueStamp();
    }

}
