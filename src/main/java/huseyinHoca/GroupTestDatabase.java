package huseyinHoca;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupTestDatabase {
	
	    @BeforeGroups({"database","abc","cde"})
	    public void setupDB() {
	        System.out.println("setupDB()");
	    }
	    @Test(groups =  {"selenium-test_website_01","selenium-test_website_02"})
	    public void runSelenium() {
	        System.out.println("runSelenium()");
	    }
	    @Test(groups = "selenium-test")
	    public void runSelenium1() {
	        System.out.println("runSelenium()1");
	    }
	    @Test(groups = "database")
	    public void testConnectOracle() {
	        System.out.println("testConnectOracle()");
	    }
	    @Test(groups = {"database", "selenium-test_website_01"})
	    public void testConnectMsSQL() {
	        System.out.println("testConnectMsSQL");
	    }
	    @Test(dependsOnGroups = {"database"}) // <--
	    public void runFinal() {
	        System.out.println("runFinal");
	    }
	    
	    @AfterGroups("database")
	    public void cleanDB() {
	        System.out.println("cleanDB()");
	    }
	}
	


















