package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            ExtentSparkReporter spark =
                    new ExtentSparkReporter("Reports/ExtentReport.html");

            spark.config().setReportName("Selenium Java Framework");

            spark.config().setDocumentTitle("Automation Test Results");

            extent = new ExtentReports();

            extent.attachReporter(spark);

            extent.setSystemInfo("Tester", "Yogeswari");

            extent.setSystemInfo("Framework", "Selenium Java");

            extent.setSystemInfo("Environment", "QA");
        }

        return extent;
    }
}