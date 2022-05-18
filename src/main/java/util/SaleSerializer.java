package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Sale;
import org.apache.kafka.common.serialization.Serializer;

/**
 * @author pablo.cavalcante - pablohenriq100@gmail.com
 * @date 06/11/2021 18:42
 */

public class SaleSerializer implements Serializer<Sale> {

  @Override
  public byte[] serialize(String s, Sale sale) {
    try {
      return new ObjectMapper().writeValueAsBytes(sale);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return null;
  }
}
