/**
 * 
 */
package com.virtusa.service;

import com.virtusa.model.CurrencyStore;

/**
 * @author NPS
 *
 */
public class CurrencyValidator {

	/**
	 * Validate the incoming String array for valid combination of symbols
	 * 
	 * @param inpCurrencyVarArr
	 * @return
	 */
	public boolean validateInputCurrencySeq(String[] inpCurrencyVarArr) {
		boolean isValid = true;
		for(int i=0;i<inpCurrencyVarArr.length;i++) {
			
			if(inpCurrencyVarArr.length>3 && CurrencyStore.repeatableSymbolList.contains(inpCurrencyVarArr[i])) {
				if(inpCurrencyVarArr[i]==inpCurrencyVarArr[i+1] && inpCurrencyVarArr[i]==inpCurrencyVarArr[i+2] && inpCurrencyVarArr[i]==inpCurrencyVarArr[i+3]) {
					isValid = false;
					break;
				}
			}
			
			if(CurrencyStore.neverRepeatableSymbolList.contains(inpCurrencyVarArr[i])) {
				for(int j=i+1;j<inpCurrencyVarArr.length;j++) {
					if(inpCurrencyVarArr[i]==inpCurrencyVarArr[j]) {
						isValid=false;
						break;
					}
				}
			}
		}
		
		return isValid;
	}
}
