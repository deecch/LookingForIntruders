package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;



public class CheckTextBox {

	private WebDriver driver;
	private String baseUrl;
	public ArrayList<String> nesto(List<WebElement> nnn) {
		ArrayList<String> novo = new ArrayList<>();
		for(int i = 0; i < nnn.size(); i++) {
			if(nnn.get(i).getText().equals("") == false &&
					nnn.get(i).getTagName().equals("a")) {
					novo.add(nnn.get(i).getText());
			}
		}
		return novo;
	}
	
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();		
		baseUrl = "http://letskodeit.teachable.com/pages/practice";
		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws Exception {
		driver.get(baseUrl);
		Random ramdomb = new Random();
		//boolean value = ramdomb.nextBoolean();
		List<WebElement> allElements = driver.findElements(By.xpath("//*"));
		int size = allElements.size();
		System.out.println(size);
		/*for (int i=0; i<size; i++) {
			if(allElements.get(i).getText().equals("") == false &&
					allElements.get(i).getTagName().equals("a")) {
				System.out.println("[" + allElements.get(i).getTagName() +"]" + " - " + allElements.get(i).getText()
								+ " - " + ramdomb.nextBoolean());
			}
				
		}*/
		ArrayList<String> novo = (nesto(allElements));
		System.out.println(novo);
	}
	
	@After
	public void tearDown() throws Exception {
	}

}
