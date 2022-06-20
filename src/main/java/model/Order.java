package model;

/**
 * Order model class
 *
 * @author Daniel Reckerth
 */
public class Order {
  private int id;
  private double quantity;
  private double totalPrice;

  private int product_id;

  public Order() {
  }

  public Order(int id, double quantity, double totalPrice, int product_id) {
    this.id = id;
    this.quantity = quantity;
    this.totalPrice = totalPrice;
    this.product_id = product_id;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public double getQuantity() {
    return quantity;
  }

  public void setQuantity(double quantity) {
    this.quantity = quantity;
  }

  public double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(double totalPrice) {
    this.totalPrice = totalPrice;
  }

  public int getProduct_id() {
    return product_id;
  }

  public void setProduct_id(int product_id) {
    this.product_id = product_id;
  }

  @Override
  public String toString() {
    return "Order{" +
        "id=" + id +
        ", quantity=" + quantity +
        ", totalPrice=" + totalPrice +
        ", product_id=" + product_id +
        '}';
  }
}
