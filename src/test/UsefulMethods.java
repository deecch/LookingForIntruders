package test;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebElement;

import com.opencsv.CSVReader;

public class UsefulMethods {

	static Properties props = new Properties();
	static CSVReader reader = null;

	
	static void isEnglishWord(String word) throws IOException { 
		FileInputStream fis = new FileInputStream("src//config.properties");
		props.load(fis);
		String file = props.getProperty("csv");
		Map<Integer, String> mp = new HashMap<>(); 
		try {
            reader = new CSVReader(new FileReader(file), ',');
            String [] nextLine;
            int i = 0;

            while ((nextLine = reader.readNext()) != null) 	{
            	for (String text : nextLine) {
            		mp.put(i++, text);
            		
            	}
            }          

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
		
		

		if (mp.containsValue(word)) {
			System.out.println(word + " - Correct");
			
		}else {
			System.out.println(word + " - Incorrect");
			
			}
	} 
	
	static void isEnglishWord(List<String> words) throws IOException { 
		FileInputStream fis = new FileInputStream("src//config.properties");
		props.load(fis);
		String file = props.getProperty("csv");
		Map<Integer, String> mp = new HashMap<>(); 
		try {
            reader = new CSVReader(new FileReader(file), ',');
            String [] nextLine;
            int i = 0;

            while ((nextLine = reader.readNext()) != null) 	{
            	for (String text : nextLine) {
            		mp.put(i++, text);
            		
            	}
            }          

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
		int size = words.size();
		for (int i = 0; i < size; i++) {
			if (mp.containsValue(words.get(i))) {
				if(words.get(i).equals(" ") == false)
				System.out.println(words.get(i) + " - Correct");
			
			}else {
				System.out.println(words.get(i) + " - Incorrect");
			
			}
		}
	}
	
	static ArrayList<String> splittingString(List<WebElement> allElements) {
		ArrayList<String> outputElements = new ArrayList<>();
		ArrayList<String> inputElements = new ArrayList<>();
		for (int i = 0; i < allElements.size(); i++) {
			if(allElements.get(i).getText().equals("") == false) {
				inputElements.add(allElements.get(i).getText().toLowerCase().trim()
						.replaceAll("[^a-zA-Z0-9]", " "));
			}
		}
		for (int j = 0; j < inputElements.size(); j++) {	
			String [] newElement = inputElements.get(j).split(" ");
			for(int z = 0; z < newElement.length; z++) {
				if(newElement[z].isEmpty() == false)
				outputElements.add(newElement[z]);
			}
		}
		
		return outputElements;
	}
}
