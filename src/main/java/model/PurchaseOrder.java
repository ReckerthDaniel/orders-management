package model;

import java.time.LocalDate;

/**
 * Purchase order model class
 *
 * @author Daniel Reckerth
 */
public class PurchaseOrder {
  private int id;
  private LocalDate purchaseDate;
  private int client_id;
  private int order_id;

  public PurchaseOrder() {
  }

  public PurchaseOrder(int id, LocalDate purchaseDate, int client_id, int order_id) {
    this.id = id;
    this.purchaseDate = purchaseDate;
    this.client_id = client_id;
    this.order_id = order_id;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public LocalDate getPurchaseDate() {
    return purchaseDate;
  }

  public void setPurchaseDate(LocalDate purchaseDate) {
    this.purchaseDate = purchaseDate;
  }

  public int getClient_id() {
    return client_id;
  }

  public void setClient_id(int client_id) {
    this.client_id = client_id;
  }

  public int getOrder_id() {
    return order_id;
  }

  public void setOrder_id(int order_id) {
    this.order_id = order_id;
  }

  @Override
  public String toString() {
    return "PurchaseOrder{" +
        "id=" + id +
        ", purchaseDate=" + purchaseDate +
        ", client_id=" + client_id +
        ", order_id=" + order_id +
        '}';
  }
}
