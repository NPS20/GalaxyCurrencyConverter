/**
 * 
 */
package com.virtusa.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author NPS
 *
 */
public class CurrencyStore {

	public static HashMap<String, Integer> romanCurrencyMap = populateRomanCurrencyMap();
	public static ArrayList<String> repeatableSymbolList = populateRepeatableSymbolList();
	public static ArrayList<String> neverRepeatableSymbolList = populateNeverRepeatableSymbolList();
	public static HashMap<String, Integer> galaxyCurrencyMap = new HashMap<String, Integer>();
	
	/**
	 * Store the roman currency symbols and their values
	 * 
	 * @return
	 */
	public static HashMap<String, Integer> populateRomanCurrencyMap(){
		romanCurrencyMap = new HashMap<String, Integer>();
		romanCurrencyMap.put("I", 1);
		romanCurrencyMap.put("V", 5);
		romanCurrencyMap.put("X", 10);
		romanCurrencyMap.put("L", 50);
		romanCurrencyMap.put("C", 100);
		romanCurrencyMap.put("D", 500);
		romanCurrencyMap.put("M", 1000);
		
		return romanCurrencyMap;
	}
	
	/**
	 * Store symbols that can be repeated
	 * 
	 * @return
	 */
	public static ArrayList<String> populateRepeatableSymbolList(){
		repeatableSymbolList = new ArrayList<String>();
		repeatableSymbolList.add("I");
		repeatableSymbolList.add("X");
		repeatableSymbolList.add("C");
		repeatableSymbolList.add("M");
		
		return repeatableSymbolList;
	}
	
	/**
	 * Store symbols that can never be repeated
	 * 
	 * @return
	 */
	public static ArrayList<String> populateNeverRepeatableSymbolList(){
		neverRepeatableSymbolList = new ArrayList<String>();
		neverRepeatableSymbolList.add("D");
		neverRepeatableSymbolList.add("L");
		neverRepeatableSymbolList.add("V");
				
		return repeatableSymbolList;
	}
	
	
}
