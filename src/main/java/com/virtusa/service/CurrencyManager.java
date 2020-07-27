/**
 * 
 */
package com.virtusa.service;

import org.apache.commons.lang3.StringUtils;

import com.virtusa.model.CurrencyStore;

/**
 * @author NPS
 *
 */
public class CurrencyManager {
	
	/**
	 * Validate and either store new galaxy symbol directly to galaxy currency map or calculate
	 * to find the value of galaxy symbol based on previous galaxy symbols and roman symbols va;lues
	 * 
	 * @param userInp
	 */
	public void storeNewCurrency(String userInp) {
		
		String inpCurrencyExpression = userInp.substring(0, userInp.indexOf("=")).trim();
		String inpCurrencyExpressionVal = userInp.substring(userInp.indexOf("=")+1, userInp.length()).trim();
				
		String [] inpCurrencyVarArr = inpCurrencyExpression.split("\\s");
		if(inpCurrencyVarArr.length > 1) {
						
			//validate
			CurrencyValidator currvalidator = new CurrencyValidator();
			boolean isValid = currvalidator.validateInputCurrencySeq(inpCurrencyVarArr);
			
			// convert to Roman Currency Array
			if(isValid) {
				String[] romanCurrArr = convertToRomanCurrencyArr(inpCurrencyVarArr);
			}
		}else if(inpCurrencyVarArr.length == 1){
			
			System.out.println("assign after check");
			int inpCurrencyVal = 0;
			if(!StringUtils.isNumeric(inpCurrencyExpressionVal)) {
				inpCurrencyVal = convertSymbolToNumber(inpCurrencyExpressionVal);
			}else {
				inpCurrencyVal = Integer.parseInt(inpCurrencyExpressionVal);
			}
			populateGalaxyCurrencyMap(inpCurrencyVarArr[0], inpCurrencyVal);
		}else {
			System.out.println("Please check the input");
		}
	}
	
	/**
	 * Convert input roman currency symbol tonumeric value
	 * 
	 * @param inpCurrencyExpressionVal
	 * @return
	 */
	public Integer convertSymbolToNumber(String inpCurrencyExpressionVal) {
		Integer currencyVal = null;
		
		if(CurrencyStore.romanCurrencyMap.containsKey(inpCurrencyExpressionVal)) {
			currencyVal = CurrencyStore.romanCurrencyMap.get(inpCurrencyExpressionVal);
		}
		
		return currencyVal;
	}
	
	/**
	 * populate the galaxy currency map
	 * 
	 * @param inpCurrencyVar
	 * @param inpCurrencyVal
	 */
	public void populateGalaxyCurrencyMap(String inpCurrencyVar, Integer inpCurrencyVal) {
		CurrencyStore.galaxyCurrencyMap.put(inpCurrencyVar, inpCurrencyVal);
	}
	
	/**
	 * Convert Incoming symbols from galaxy version to roman literals
	 * 
	 * @param inpGalaxyCurrencyArr
	 * @return
	 */
	public String[] convertToRomanCurrencyArr(String[] inpGalaxyCurrencyArr) {
		
		String[] romanCurrArr = new String[inpGalaxyCurrencyArr.length];
		int unknownVarCount = 0;
		String unknownVar = null;
				
		for(int i=0;i<inpGalaxyCurrencyArr.length;i++) {
			
			if(unknownVarCount >1) {
				System.out.println("too many unknown variables in Input.");
				System.exit(0);
			}else if(!CurrencyStore.romanCurrencyMap.containsKey(inpGalaxyCurrencyArr[i])){
				
				unknownVarCount++;
				//Key to be added to Galaxy Currency map with value as compute of other symbols
				unknownVar = inpGalaxyCurrencyArr[i];
			}else if(CurrencyStore.romanCurrencyMap.containsKey(inpGalaxyCurrencyArr[i])) {
				
				romanCurrArr[i] = inpGalaxyCurrencyArr[i];
			}
			
			
		}
		return romanCurrArr;
	}
}
