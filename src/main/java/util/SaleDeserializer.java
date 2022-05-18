package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Sale;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

/**
 * @author pablo.cavalcante - pablohenriq100@gmail.com
 * @date 06/11/2021 18:50
 */

public class SaleDeserializer implements Deserializer<Sale> {

  @Override
  public Sale deserialize(String s, byte[] bytes) {
    try {
      return new ObjectMapper().readValue(bytes, Sale.class);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}
