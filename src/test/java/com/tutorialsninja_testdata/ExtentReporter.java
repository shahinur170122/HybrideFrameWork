package com.tutorialsninja_testdata;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	public static ExtentReports generateExtentReport() throws Exception {
		
		ExtentReports extentReport = new ExtentReports();
		
		File extentReportFile = new File(System.getProperty("user.dir")  + "\\test-output\\ExtentReports\\extentreport.html");
		
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Tutorialsninja Automation Results");
		sparkReporter.config().setDocumentTitle("TNReportTitle|HybrideFrameWorkBatch");
		sparkReporter.config().setTimeStampFormat("MM/dd/yyyy hh:mm:ss");
		
		
		extentReport.attachReporter(sparkReporter);
		
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\tutorialsninja_config\\config.properties");
		prop.load(ip);
		
		extentReport.setSystemInfo("application url", prop.getProperty("url"));
		extentReport.setSystemInfo("browswer name", prop.getProperty("browser"));
		extentReport.setSystemInfo("email",prop.getProperty("validEmail"));
		extentReport.setSystemInfo("password", prop.getProperty("validPassword"));
		extentReport.setSystemInfo("operating system", System.getProperty("os.name"));
		extentReport.setSystemInfo("ops version detail", System.getProperty("os.version"));
		extentReport.setSystemInfo("SDET Name",System.getProperty("user.name"));
		extentReport.setSystemInfo("java version",System.getProperty("java.version"));
		extentReport.setSystemInfo("java vendor", System.getProperty("java.vendor"));
		
		return extentReport;
	}

}
