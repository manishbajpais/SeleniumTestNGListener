package seleniumtestNGlistener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import seleniumQAbase.BaseClass;

public class RetryAnalyzer extends BaseClass implements IRetryAnalyzer{
	int counter = 0;
	int retrylimit =3;

	public boolean retry(ITestResult result) {
		if(counter<retrylimit) {
			counter++;
			return true;
		}
		return false;
	}

}
