package listner;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;


//@Listeners(listner.ListnerClass.class)


public class AccessDemoWorkShop1 extends DemoWorkShop {
	
	@Test(retryAnalyzer = listner.Readtry.class)
	public void addAddress()
	{
		Assert.fail();
		Reporter.log("Add Address successfully", true);
	}

}
