
package io.amecodelabs.adapter;

import java.util.List;

/**
 *
 * @author Alan M.E
 * @see 03/03/2017
 */

public interface IConversor<T> {
    
    void toDeposit(String amount, String subject);
    boolean extract(String amount);
    List<T> historial();
    String totalAmount();

}
