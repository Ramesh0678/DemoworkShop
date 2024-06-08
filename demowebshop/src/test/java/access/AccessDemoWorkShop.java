package access;
import org.testng.Reporter;
import org.testng.annotations.Test;
import listner.DemoWorkShop;

public class AccessDemoWorkShop extends DemoWorkShop {
	@Test(groups="smoke")
	public void addAddress()
	{
		String browser = System.getProperty("broswer");
		System.out.println(browser);
		Reporter.log("Add Address successfully", true);
	}

}
