import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.FileWriter;
import java.io.PrintWriter;

public class Emedco_Regression {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://www.emedco.com/");
		selenium.start();
	}

	@Test
	public void ReadNavigationBar() throws Exception {
		
		selenium.open("http://www.emedco.com");
		selenium.waitForPageToLoad("60000");
		String generateEmedcoRegressionNavigation="////10.192.200.25//CSV//Emedco_Navigation_TestResult.txt";
		FileWriter fw = new FileWriter(generateEmedcoRegressionNavigation);
		PrintWriter pw = new PrintWriter(fw);
		
		int a=1,b=1,c=1,d=1;
		
		while (selenium.isElementPresent("//*[@id='nav']/li["+a+"]/a/")){
			//System.out.println("a = " + a);
			String TextLevel1 = selenium.getText("//*[@id='nav']/li["+a+"]/a/");
			String URLLevel1 = selenium.getAttribute("xpath=//*[@id='nav']/li["+a+"]/a/@href");
			//System.out.println(TextLevel1);
			//System.out.println(URLLevel1);
			
			while (selenium.isElementPresent("//*[@id='nav']/li["+a+"]/div/ul/li["+b+"]/a/")){
				//System.out.println("b = " + b);
				String TextLevel2 = selenium.getText("//*[@id='nav']/li["+a+"]/div/ul/li["+b+"]/a/");
				String URLLevel2 = selenium.getAttribute("xpath=//*[@id='nav']/li["+a+"]/div/ul/li["+b+"]/a/@href");
				//System.out.println(TextLevel2);
				//System.out.println(URLLevel2);
								
				if ((selenium.isElementPresent("//*[@id='nav']/li["+a+"]/div/ul/li["+b+"]/div/ul/li["+c+"]/a/"))==false) {
					pw.print(TextLevel1+"|"+URLLevel1+"|"+TextLevel2+"|"+URLLevel2+"|"+"|"+"|"+"|");
					pw.println();
					pw.flush();
				} else {
					while (selenium.isElementPresent("//*[@id='nav']/li["+a+"]/div/ul/li["+b+"]/div/ul/li["+c+"]/a/")){
						//System.out.println("c = " + c);
						String TextLevel3 = selenium.getText("//*[@id='nav']/li["+a+"]/div/ul/li["+b+"]/div/ul/li["+c+"]/a/");
						String URLLevel3 = selenium.getAttribute("xpath=//*[@id='nav']/li["+a+"]/div/ul/li["+b+"]/div/ul/li["+c+"]/a/@href");
						//System.out.println(TextLevel3);
						//System.out.println(URLLevel3);
												
						if ((selenium.isElementPresent("//*[@id='nav']/li["+a+"]/div/ul/li["+b+"]/div/ul/li["+c+"]/div/ul/li["+d+"]/a/"))==false) {
							pw.print(TextLevel1+"|"+URLLevel1+"|"+TextLevel2+"|"+URLLevel2+"|"+TextLevel3+"|"+URLLevel3+"|"+"|");
							pw.println();
							pw.flush();
						} else {
							while (selenium.isElementPresent("//*[@id='nav']/li["+a+"]/div/ul/li["+b+"]/div/ul/li["+c+"]/div/ul/li["+d+"]/a/")){
								//System.out.println("d = " + d);
								String TextLevel4 = selenium.getText("//*[@id='nav']/li["+a+"]/div/ul/li["+b+"]/div/ul/li["+c+"]/div/ul/li["+d+"]/a/");
								String URLLevel4 = selenium.getAttribute("xpath=//*[@id='nav']/li["+a+"]/div/ul/li["+b+"]/div/ul/li["+c+"]/div/ul/li["+d+"]/a/@href");
								//System.out.println(TextLevel4);
								//System.out.println(URLLevel4);
								pw.print(TextLevel1+"|"+URLLevel1+"|"+TextLevel2+"|"+URLLevel2+"|"+TextLevel3+"|"+URLLevel3+"|"+TextLevel4+"|"+URLLevel4);
								pw.println();
								pw.flush();
								d++;
							}	
						}
						c++;
						d=1;
					}
				}
				b++;
				c=1;
			}
			a++;
			b=1;
		} 
	pw.println(teststring());
	pw.close();
	fw.close();
	}
	
	public static String teststring() {
		return null;
	}
	
	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}

