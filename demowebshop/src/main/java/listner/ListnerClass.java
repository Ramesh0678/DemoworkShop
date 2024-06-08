package listner;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListnerClass extends AccessDemoWorkShop1 implements ITestListener,ISuiteListener

{
	public void onFinish(ISuite suite) {
		Reporter.log(suite.getName()+"testscript onFinish", true);
	}
	public void onTestSkipped(ITestResult result) {
		Reporter.log(result.getName()+"testscript onTestSkipped", true);

	}
	public void onStart(ISuite suite) {
		Reporter.log(suite.getName()+"testscript onStart", true);
		
	}
	public void onTestFailure(ITestResult result) {
		Reporter.log(result.getName()+"test script Failure", true);
		TakesScreenshot ts=(TakesScreenshot) driver;
		File ts1 = ts.getScreenshotAs(OutputType.FILE);
		File path=new File("./Failurier/"+result.getName()+".png");
		try {
			FileHandler.copy(ts1, path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
