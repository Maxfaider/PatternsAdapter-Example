package io.amecodelabs;

import java.util.List;

import io.amecodelabs.adapter.CashEuros;
import io.amecodelabs.adapter.ConversorPesos;
import io.amecodelabs.adapter.IConversor;
import io.amecodelabs.adapter.Register;

/**
*
* @author Alan M.E
* @see 03/03/2017
*/

public class Principal {

   public static void main(String[] args) {
       IConversor conversor = new ConversorPesos(new CashEuros());
       conversor.toDeposit("200000", "Giro");
       conversor.toDeposit("100000", "Giro");
       conversor.extract("150000");
       
       System.out.println("Saldo Total: "+conversor.totalAmount());
       
       getInforme(conversor);
       
	   
   }
   
   public static void getInforme(IConversor conversor) {
	   System.out.println("====Historial====");
	   List<Register> historic = conversor.historial();
       historic.forEach((index) -> {
           System.out.println(index.toString());
       });
   }
   
}
