package listner;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Readtry implements IRetryAnalyzer {
	int count=0;
	int limit=5;
	public boolean retry(ITestResult result) {
		if(count<limit)
		{
			count++;
			return true;
		}
		
		return false;
	}
	

}
