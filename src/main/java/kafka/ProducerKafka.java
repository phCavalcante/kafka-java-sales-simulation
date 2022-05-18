package kafka;

import domain.Sale;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import util.MailSenderSimulator;
import util.SaleSerializer;
import util.SalesGenerator;

import java.util.Properties;

/**
 * @author pablo.cavalcante - pablohenriq100@gmail.com
 * @date 06/11/2021 17:47
 */

 public class ProducerKafka extends Thread {

   private SalesGenerator salesGenerator = new SalesGenerator();
   private static final Properties properties = new Properties();
   private static MailSenderSimulator mailSenderSimulator = new MailSenderSimulator();

  static {
   properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
   properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
   properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, SaleSerializer.class.getName());
  }

  @Override
  public void run() {
    try(KafkaProducer<String, Sale> producer = new KafkaProducer<>(properties)) {
      while (true) {
        ProducerRecord<String, Sale> record = new ProducerRecord<>("sale",
            salesGenerator.generator());
        producer.send(record);
        mailSenderSimulator.send(null);
        Thread.sleep(100);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
