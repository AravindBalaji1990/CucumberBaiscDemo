package stepdefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    public static ExtentReports extent;
    public static ExtentTest test;

    public static ExtentReports createIntance() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("target/ExtentReport.html");
        reporter.config().setReportName("Smaple Report Appium Cucumber");
        reporter.config().setDocumentTitle("Cucumber Report Integration");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Sytem Executed", "MAC");
        extent.setSystemInfo("Environment", "QA");

        return extent;
    }

    public  static  ExtentReports getExtent(){
        if(extent == null){
            extent = createIntance();
        }

        return extent;
    }

    public static ExtentTest createTest(String name){
        test = getExtent().createTest(name);
        return test;
    }

    public static void flush(){
        getExtent().flush();
    }
}
