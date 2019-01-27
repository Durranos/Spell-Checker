/**
 * Class: CEN 3024
 * Author: David Kearney
 * Date: 01/27/2019
 * Assignment 3 - Spell Checker
 */

package kearney_Spell_Checker;
import java.io.*;
import java.util.*;

public class Spell_Checker_Main {

	public static void main(String[] args) throws IOException {
		// Initial size for array lists
		int SIZE = 100;
		
		// Declare ArrayList for testFile with size SIZE
		ArrayList<String> testList = new ArrayList<String>(SIZE);
		
		// Declare ArrayList for dictionaryFile with size SIZE
		ArrayList<String> dictionaryList = new ArrayList<String>(SIZE);
		
		// Read the text files and store them in their ArrayList Collection
		testList = readFile("src/kearney_Spell_Checker/testStates.txt", SIZE);
		dictionaryList = readFile("src/kearney_Spell_Checker/dictionary.txt", SIZE);
		
		// Compare the two ArrayLists to each other
		compare(testList, dictionaryList);
	}
	
	// Reads an incoming file and stores each new line into a new index in the ArrayList
	static ArrayList<String> readFile(String fileName, int SIZE){
		// Temporary ArrayList
		ArrayList<String> temp = new ArrayList<String>(SIZE);
		
		// File to be read
		File file = new File(fileName);
		String line;
		
		// Basic file reading
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			while ((line = br.readLine()) != null) {
				// Add the new line to the ArrayList
				temp.add(line);
			}
		} catch(FileNotFoundException ex) {
			ex.printStackTrace();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		
		// Return the completed ArrayList
		return temp;
	}
	
	// Compares the two ArrayLists to each other
	static void compare(ArrayList<String> testList, ArrayList<String> dictionary) {

		// Determines if the index item in testList exists in dictionary List
		int result = 0;
		
		// Print out the two ArrayLists
		System.out.println("Test File: ");
		System.out.println(testList);
		
		System.out.println("Dictionary: ");
		System.out.println(dictionary);
		
		System.out.println("Unknown Words: ");
		
		// Loop through the two ArrayLists
		for(int i = 0; i < testList.size(); i++) {
			for(int j = 0; j < dictionary.size(); j++) {
				// Compare each index item in testList against each index item in dictionary
				result = testList.get(i).compareTo(dictionary.get(j));
				
				// If the two indexes match each other, we've found a match so exit the nested for loop
				if(result == 0) {
					break;
				}
			}
			// We had to loop through the entire nested loop
			// The index item in testList does not exist in dictionary
			if(result != 0)
				System.out.print(testList.get(i) + " ");
		}
	}
}
