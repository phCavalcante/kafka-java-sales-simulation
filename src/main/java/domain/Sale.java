package domain;

import util.SaleStatus;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author pablo.cavalcante - pablohenriq100@gmail.com
 * @date 06/11/2021 17:48
 */

 public class Sale implements Serializable {

  private Long id;
  private Long idClient;
  private Integer numberTickets;
  private BigDecimal amount;
  private SaleStatus status;

  public Sale(){
  }

 public Long getId() {
  return id;
 }

 public void setId(Long id) {
  this.id = id;
 }

 public Long getIdClient() {
  return idClient;
 }

 public void setIdClient(Long idClient) {
  this.idClient = idClient;
 }

 public Integer getNumberTickets() {
  return numberTickets;
 }

 public void setNumberTickets(Integer numberTickets) {
  this.numberTickets = numberTickets;
 }

 public BigDecimal getAmount() {
  return amount;
 }

 public void setAmount(BigDecimal amount) {
  this.amount = amount;
 }

 public SaleStatus getStatus() {
  return status;
 }

 public void setStatus(SaleStatus status) {
  this.status = status;
 }

 @Override
 public String toString() {
  return "Sale{" +
      "id=" + id +
      ", idClient=" + idClient +
      ", numberTickets=" + numberTickets +
      ", amount=" + amount +
      ", status=" + status +
      '}';
 }
}
