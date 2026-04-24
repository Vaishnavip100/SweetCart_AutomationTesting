package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ExtentManager {
    private static ExtentReports extent;
    public static ExtentReports getInstance() {
        if (extent==null) {
            String reportDir=System.getProperty("user.dir") + "/reports/";
            String reportPath=reportDir + "ExtentReport.html";

            File dir=new File(reportDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            ExtentSparkReporter reporter=new ExtentSparkReporter(reportPath);
            reporter.config().setReportName("Sweet Shop Automation Report");
            extent=new ExtentReports();
            extent.attachReporter(reporter);
        }
        return extent;
    }
}