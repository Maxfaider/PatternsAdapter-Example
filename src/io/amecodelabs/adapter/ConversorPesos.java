
package io.amecodelabs.adapter;

import java.math.BigDecimal;
import java.util.List;

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
		BigDecimal pesos = new BigDecimal(amount);
		double euroNow = ForeignExchange.callService();
		
		pesos = pesos.divide(new BigDecimal(euroNow), 2, 
				BigDecimal.ROUND_DOWN);
		
        this.caja.addEuros(pesos, subject);
	}

	@Override
	public boolean extract(String amount) {
		BigDecimal pesos = new BigDecimal(amount);
		double euroNow = ForeignExchange.callService();
		
		pesos = pesos.divide(new BigDecimal(euroNow), 2,
				BigDecimal.ROUND_DOWN);
		
		return this.caja.extractEuros(pesos);
	}

	@Override
	public List<Register> historial() {
		return this.caja.getHistoric();
	}

	@Override
	public String totalAmount() {
		BigDecimal amountEuro = new BigDecimal(this.caja.getAmount());
		double euroNow = ForeignExchange.callService();
		
		BigDecimal amountPesos = amountEuro.multiply(
				new BigDecimal(euroNow));
		
		return amountPesos.toString();
	}

	

	
    /*@Override
    public void depositar(double monto, String asunto) {
        monto = monto / valorEuro;
        this.caja.ingresarEuros(monto, asunto);
    }

    @Override
    public boolean retirar(double monto) {
        monto = monto / valorEuro;
        return this.caja.sacarEuros(monto);
    }

    @Override
    public double saldoTotal() {
        return this.caja.getMonto() * valorEuro;
    }

    @Override
    public List<Registro> historial() {
        return this.caja.getHistorial();
    }*/
    
}
