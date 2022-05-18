package util;

import domain.Sale;

import java.math.BigDecimal;
import java.util.Random;

/**
 * @author pablo.cavalcante - pablohenriq100@gmail.com
 * @date 06/11/2021 17:57
 */

 public class SalesGenerator {

 private Random random = new Random();

 public Sale generator() {
  Sale sale = new Sale();
  Long aux = random.nextLong();
  sale.setId(aux > 0 ? aux : aux*-1);
  aux = random.nextLong();
  sale.setIdClient(aux > 0 ? aux : aux*-1);
  sale.setNumberTickets(random.nextInt(100));
  sale.setAmount(BigDecimal.valueOf(sale.getNumberTickets()).multiply(BigDecimal.valueOf(35.5)));
  return sale;
 }
}
