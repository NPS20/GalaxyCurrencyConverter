/**
 * 
 */
package com.virtusa.controller;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import com.virtusa.model.CurrencyStore;
import com.virtusa.service.CurrencyManager;

/**
 * @author NPS
 *
 */
public class ConversionController {
	
	CurrencyManager currencyManager = new CurrencyManager();
	
	/**
	 * The program takes in user input like "glob=I" to assign galaxy currency symbol glob to the roman currency symbol I
	 * OR the input can be "glob silver=4500", which is used to calcuate the value of silver in galaxy symbols and assign
	 * OR the input can be "glob glob pish?" with a question to calculate its value and return back
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		Set<Entry<String, Integer>> entrySet = CurrencyStore.romanCurrencyMap.entrySet();
		Iterator<Entry<String, Integer>> entryIterator = entrySet.iterator();
		System.out.println("this i");
		while(entryIterator.hasNext()) {
			Entry<String, Integer> entry = entryIterator.next();
			 System.out.println(entry.getKey());
			 System.out.println(entry.getValue());
		}
		
		// Take input and store other currency, with Validation
		ConversionController conversionController = new ConversionController();
		conversionController.processUserInput();
	}
	
	/**
	 * Prompt user to provide input and calculate accordingly
	 * 
	 */
	public void processUserInput() {
		Scanner userInp = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Enter statement");
	    String userInpStmt = userInp.nextLine();  // Read user input
	    
	    if(userInpStmt.contains("=")) {
	    	System.out.println("handle Statement ... ");
	    	currencyManager.storeNewCurrency(userInpStmt);
	    } else if (userInpStmt.contains("?")) {
	    	System.out.println("handle query ... ");
	    	// TODO
	    } else {
	    	System.out.println("I have no idea what you are talking about");
	    }
	
	    Scanner userDecisionCheck = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Do you want to quit or continue, q/c?");
	
	    String userDecision = userDecisionCheck.nextLine();  // Read user input
	    System.out.println("User input Statement is: " + userDecision);
	    
	    if("q".equalsIgnoreCase(userDecision)) {
	    	System.out.println("Quitting Galaxy Currency Converter");
	    }else if("c".equalsIgnoreCase(userDecision)) {
	    	processUserInput();
	    }
	    
	}
	

}
