import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileWriter;

public class Redirects_Selenium {
	
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("10.192.200.25", 4444, "*firefox", "http://emedco.zeondemo.com");
		selenium.start();
		//selenium.windowMaximize();
	}
	
	@Test
	public void main() throws Exception {
		String fileName = "\\\\10.192.200.25\\csv\\CSV - MWSD-140 - STAGING v1 - Emedco_June_redirects";
		String fileNameCsv = fileName + ".csv";
		File file = new File(fileNameCsv); //File = Java file class
		//java.util.Date date= new java.util.Date();
		//String generateCsv = fileName + "_" + date + "_" + "_TestResults.csv";
		String generateCsv = fileName+"_TestResults.csv";
		FileWriter fw = new FileWriter(generateCsv);	//This is the FileWriter
		PrintWriter pw = new PrintWriter(fw);	//This Writes the Content of the File
		pw.println("Current URL"+","+"Redirect To URL"+","+"Requestor"+","+"Date"+","+"Actual Redirect URL"+","+"404 on Title"+","+"Test Result");
		pw.flush();
		int x = 1;
		String TestResult = ("");
		//SETONCA = "404 Not Found"
		//SETONUS = "404 Not Found"
		//EMEDCO = "Page Not Found"
		
		String NotFound = ("Page Not Found");
	
		try {
			Scanner inputStream = new Scanner(file);
			inputStream.next();inputStream.next();inputStream.next();inputStream.next();
			
			while (inputStream.hasNext()){
				String data = inputStream.next(); //Gets a whole line
				String[] values = data.split(","); //Splits the line to string array per delimeter used
				System.out.println(x);
				//System.out.println("URL: "+values[0]);
				//System.out.println("Redirect: "+values[1]);
				//System.out.println("Reporter: "+values[2]);
				//System.out.println("Date: "+values[3]);
				//selenium.open(values[0]);
				//selenium.waitForPageToLoad("300000");
				//Thread.sleep(30000); //Instead of wait for page to load will pause value milliseconds
				try {
					selenium.open(values[0]);
				    selenium.waitForPageToLoad("30000");
				    String title = selenium.getTitle();
					String URL = selenium.getLocation();
					String RedirectUrl = values[1];
					if (URL.equals(RedirectUrl)){
						TestResult="PASS";
					}
					else {
						TestResult="FAIL";
					}					
					if (title.equals(NotFound)){
						//System.out.println("Actual: "+ NotFound);
						pw.println(values[0]+","+values[1]+","+values[2]+","+values[3]+","+URL+","+NotFound+","+(TestResult));
						pw.flush();
					}
					else {
						//System.out.println("Actual: "+URL);
						pw.println(values[0]+","+values[1]+","+values[2]+","+values[3]+","+URL+","+"ok"+","+TestResult);
						pw.flush();
					}
					x++;
				  }
				  catch (SeleniumException e) {
					  String title="Page Timeout";
					  String URL=selenium.getLocation();
					  TestResult="FAIL";
					  pw.println(values[0]+","+values[1]+","+values[2]+","+values[3]+","+URL+","+title+","+(TestResult));
					  pw.flush();
					  x++;
				  }
			}
		inputStream.close();		
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	pw.close();
	fw.close();
		
	}
	
	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}