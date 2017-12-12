package io.amecodelabs.adapter;

import java.math.BigDecimal;

/**
 * Supogamos que es un servicio que nos manda el valor actual del Euro.
 * 
 * @author Alan M.E
 * @since 03/03/2017
 */
public class ForeignExchange {
	
	private static final double euroNow = 3182.00;
	
	/**
	 * 
	 * @return divisa
	 */
	public static BigDecimal callService(String value, String change) {
		double valueEuro = Double.valueOf(value);
		
		if(change.equals("PvE")) {
			valueEuro/= euroNow;
		} else {
		    valueEuro*= euroNow;
		}
		
		return new BigDecimal(valueEuro).
				setScale(2, BigDecimal.ROUND_DOWN);
	}

}
