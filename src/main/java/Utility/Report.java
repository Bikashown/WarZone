package Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;

public class Report {
	static ExtentReports report;
	public static ExtentReports createreport()
	{
		String path=System.getProperty("user.dir")+"//Report";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Regression Report");
		reporter.config().setDocumentTitle("My Report");
		
		report=new ExtentReports();
		report.attachReporter(reporter);
		return report;
	}

}
