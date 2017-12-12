
package io.amecodelabs.adapter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Alan M.E
 * @see 03/03/2017
 */

public class CashEuros {
	
	private BigDecimal amount;
    private ArrayList<Register> historic;
    
    public CashEuros() {
        this.amount = BigDecimal.ZERO;
        this.historic = new ArrayList<Register>();
    }
    
    public void addEuros(BigDecimal amount, String subject) {
        this.amount = this.amount.add(amount);
        
        LocalDate date = LocalDate.now();
        addhistoric(new Register(subject, date.toString(), 
        		amount.toString()));
    }
    
    public boolean extractEuros(BigDecimal amount) {
        
    	if(this.amount.compareTo(amount) >= 0) {
    		this.amount = this.amount.subtract(amount);
    		return true;
    	}
    	return false;
    }
    
    private void addhistoric(Register register) {
        historic.add(register);
    }

    public String getAmount() {
        return amount.toString();
    }
    
    public ArrayList<Register> getHistoric() {
        return this.historic;
    }
    
}
