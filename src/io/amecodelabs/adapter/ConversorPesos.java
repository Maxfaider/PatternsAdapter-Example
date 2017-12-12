
package io.amecodelabs.adapter;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author Alan M.E
 * @see 03/03/2017
 */

public class ConversorPesos implements IConversor<Register> {

    private CashEuros caja;
    
    public ConversorPesos(CashEuros caja) {
        this.caja = caja;
    }

	@Override
	public void toDeposit(String amount, String subject) {
		BigDecimal euros = ForeignExchange.
				callService(amount, "PvE");
		
        this.caja.addEuros(euros, subject);
	}

	@Override
	public boolean extract(String amount) {
		BigDecimal euros = ForeignExchange.
				callService(amount, "PvE");
		
		return this.caja.extractEuros(euros);
	}

	@Override
	public List<Register> historial() {
		return this.caja.getHistoric();
	}

	@Override
	public String totalAmount() {
		BigDecimal pesos = ForeignExchange.
				callService(this.caja.getAmount(), "EvP");

		return pesos.toString();
	}
	
}
