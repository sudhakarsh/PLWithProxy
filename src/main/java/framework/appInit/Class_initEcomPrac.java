package framework.appInit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.Status;

import framework.core.ImplClass_SAF_V_0_2;

public class Class_initEcomPrac extends ImplClass_SAF_V_0_2 {
	public String ConsultantName =null;
	public static String Guest_Email;
	public static String Party_Number;
	public int waitTimeout = Integer.parseInt(p.getProperty("waitTimeout"));
	public int reducedTimeout= Integer.parseInt(p.getProperty("waitTimeout"))-55;
	public Class_initEcomPrac() throws FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeSuite(groups= {"Common"})
	public void beforeSuite(){
		initExtentReport();
	}

	@BeforeClass(groups= {"Common"})
	public void beforeClass(){		
		startTestModule(tcName, tcDescription);
		Test = startTestCase(testNodes);
	}
    
	@BeforeMethod(groups= {"Common"})
	public void beforeMethod(){
		
		Test.assignCategory(category);
		Test.assignAuthor(authors);
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("./Properties/App.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties p = new Properties();
		try {
			p.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		startApp(p.getProperty("browserApp"), p.getProperty("URL"), p.getProperty("HeadlessMode"));
	}

	@AfterSuite(groups= {"Common"})
	public void afterSuite(){
		endResult();
	}

	@AfterMethod(groups= {"Common"})
	public void afterMethod(){
		
		closeAllBrowsers();
	}

	@AfterMethod (groups= {"Common"})
	public void markExtentReportWithTestNGFailStatus(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			
			Test.log(Status.FAIL,"Exception has occurred on re-execution, marking it as fail.");

		}
			}
}


	

