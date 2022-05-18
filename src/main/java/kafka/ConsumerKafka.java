package kafka;

import domain.Sale;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import util.SaleDeserializer;
import util.SaleStatus;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import java.util.Random;
import java.util.Vector;

/**
 * @author pablo.cavalcante - pablohenriq100@gmail.com
 * @date 06/11/2021 17:47
 */

 public class ConsumerKafka extends Thread {

  private static Properties properties = new Properties();
  private static Vector<Sale> saleList = new Vector<>();
  static {
   properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
   properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, SaleDeserializer.class.getName());
   properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
   properties.put(ConsumerConfig.GROUP_ID_CONFIG, "group1");
   properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
  }

  @Override
  public void run() {
    try(KafkaConsumer<String, Sale> consumer = new KafkaConsumer(properties)) {

      consumer.subscribe(Arrays.asList("sale"));
      while(true) {
        ConsumerRecords<String, Sale> records = consumer.poll(Duration.ofSeconds(200));
        for (ConsumerRecord<String, Sale> r : records) {
          Sale sale = r.value();

          if (new Random().nextBoolean()) {
            sale.setStatus(SaleStatus.toEnum("Approved"));
          } else {
            sale.setStatus(SaleStatus.toEnum("Failed"));
          }
          Thread.sleep(200);
          System.out.println("--------######----------");
          saleList.add(sale);
          System.out.println(sale);
        }
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

  public Vector<Sale> getSaleList() {
    return saleList;
  }
}
