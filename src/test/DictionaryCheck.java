package test;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DictionaryCheck {

	public static void main(String[] args) throws IOException {

		WebDriver driver;
		String baseUrl;
		driver = new FirefoxDriver();
		baseUrl = "https://deecch.github.io";
		// baseUrl = "https://www.google.com/";

		driver.get(baseUrl);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		List<WebElement> allElements = driver.findElements(By.xpath("//*"));
		// List<WebElement> allElements = driver.findElements(By.tagName("a"));

		ArrayList<String> words = UsefulMethods.splittingString(allElements);
		UsefulMethods.isEnglishWord(words);

	}
}
