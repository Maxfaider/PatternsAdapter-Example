
package io.amecodelabs.adapter;

import java.time.LocalDate;

/**
 *
 * @author Alan M.E
 * @see 03/03/2017
 */
public class Register {
    
    private String subject;
    private String date;
    private String deposit;
    
    private Register(String subject, String date, String deposit) {
        this.subject = subject;
        this.date = date;
        this.deposit = deposit;
    }
    
    public static Register createRegister(String subject, String deposit) {
    	LocalDate date = LocalDate.now();
    	return new Register(subject, date.toString(), deposit);
    }

    public String getSubject() {
        return subject;
    }
    
    public String getDate() {
        return date;
    }
    
    public String getDeposit() {
        return deposit;
    }
    
    @Override
    public String toString() {
        return "<"+getDate()+"> "+getSubject()+": "+getDeposit() + "€";
    }
    
}
