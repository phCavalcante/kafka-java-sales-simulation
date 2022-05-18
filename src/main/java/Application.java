import domain.Sale;
import kafka.ConsumerKafka;
import kafka.ProducerKafka;
import util.MailSenderSimulator;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author pablo.cavalcante - pablohenriq100@gmail.com
 * @date 06/11/2021 19:06
 */

public class Application {

  private static ConsumerKafka consumerKafka = new ConsumerKafka();
  private static ProducerKafka producerKafka = new ProducerKafka();

  public static void main(String[] args) {
    System.out.println("Ticket sales engine started.");

    producerKafka.start();
    consumerKafka.start();

    Runnable runnable = () -> {
      while(true) {
        System.out.println("Calculating total amount fo sales to date...");
        Double sum = 0.0;
        List<Sale> list = consumerKafka.getSaleList().stream().filter( sale -> sale.getStatus().toString().equalsIgnoreCase("Approved")).collect(Collectors.toList());
        for (Sale sale: list) {
          sum+= sale.getAmount().doubleValue();
        }
        System.out.println("Total sales: " + sum);
      }
    };

    Thread thread = new Thread(runnable);

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    thread.start();
  }

}
