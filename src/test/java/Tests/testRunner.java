package Tests;

import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;

public class testRunner {
	static TestNG testng;
	

	public static void main(String[] args) {
  
		TestListenerAdapter tla = new TestListenerAdapter();
		    TestNG testng = new TestNG();
		    List<String> suites = Lists.newArrayList();
		    suites.add("E:\\Parveen_data\\Shipcaddie-master\\testng.xml");
		    testng.setTestSuites(suites);
		    testng.run();
		    
	}


}