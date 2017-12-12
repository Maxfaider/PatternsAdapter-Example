
package io.amecodelabs.adapter;

/**
 *
 * @author Alan M.E
 * @see 03/03/2017
 */
public class Register {
    
    private String subject;
    private String date;
    private String deposit;
    
    public Register(String subject, String date, String deposit) {
        this.subject = subject;
        this.date = date;
        this.deposit = deposit;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setdeposit(String deposit) {
        this.deposit = deposit;
    }  
    
    @Override
    public String toString() {
        return "<"+getDate()+"> "+getSubject()+": "+getDeposit() + "€";
    }
    
}
