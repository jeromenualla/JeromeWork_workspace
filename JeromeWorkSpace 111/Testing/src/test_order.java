import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("deprecation")
public class test_order extends SeleneseTestCase {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*firefox", "http://emedco.zeondemo.com/");
		selenium.start();
		selenium.windowMaximize();
	}

	@Test
	public void test_Order() throws Exception {
		selenium.open("http://emedco.zeondemo.com/");
		//String header_cart = selenium.getText("//*[@id='cartHeader']/strong[2]/span[1]");
		verifyEquals("test", selenium.getText("//*[@id='cartHeader']/strong[2]/span[1]"));
		selenium.type("id=search", "KIT503");
		selenium.click("id=search-submit");
		selenium.waitForPageToLoad("30000");
		String sku1 = selenium.getText("//dl/dd/div/div/div/div/div/form/table/tbody/tr/td/table/tbody/tr/td[2]");
		String sku1_type = selenium.getText("//dl/dd/div/div/div/div/div/form/table/tbody/tr/td/table/tbody/tr/td[3]");
		String sku1_uom = selenium.getText("//dl/dd/div/div/div/div/div/form/table/tbody/tr/td/table/tbody/tr/td[4]");
		String sku1_qty_qty1 = selenium.getText("//dl/dd/div/div/div/div/div/form/table/tbody/tr/td/table/tbody/tr/td[5]/table/tbody/tr/td/ul/li/div");
		String sku1_price_qty1 = selenium.getText("//dl/dd/div/div/div/div/div/form/table/tbody/tr/td/table/tbody/tr/td[5]/table/tbody/tr/td/ul/li/div[2]");
		String sku1_qty_qty3 = selenium.getText("//dl/dd/div/div/div/div/div/form/table/tbody/tr/td/table/tbody/tr/td[5]/table/tbody/tr/td/ul/li[2]/div");
		String sku1_price_qty3 = selenium.getText("//dl/dd/div/div/div/div/div/form/table/tbody/tr/td/table/tbody/tr/td[5]/table/tbody/tr/td/ul/li[2]/div[2]");
		String sku1_qty_qty5 = selenium.getText("//dl/dd/div/div/div/div/div/form/table/tbody/tr/td/table/tbody/tr/td[5]/table/tbody/tr/td/ul/li[3]/div");
		String sku1_price_qty5 = selenium.getText("//dl/dd/div/div/div/div/div/form/table/tbody/tr/td/table/tbody/tr/td[5]/table/tbody/tr/td/ul/li[3]/div[2]");
		selenium.type("id=qty_id_45494", "5");
		selenium.click("id=btnaddtocart");
		Thread.sleep(10000);
		selenium.click("id=view_cart");
		selenium.waitForPageToLoad("30000");
		System.out.println(sku1);
		System.out.println(sku1_type);
		System.out.println(sku1_uom);
		System.out.println(sku1_qty_qty1);
		System.out.println(sku1_price_qty1);
		System.out.println(sku1_qty_qty3);
		System.out.println(sku1_price_qty3);
		System.out.println(sku1_qty_qty5);
		System.out.println(sku1_price_qty5);
				
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
