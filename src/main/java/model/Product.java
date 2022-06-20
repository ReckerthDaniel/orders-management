package model;

/**
 * Product model class
 *
 * @author Daniel Reckerth
 */
public class Product {
  private int id;
  private String description;
  private double price;
  private double stock;

  public Product() {
  }

  public Product(int id, String description, double price, double stock) {
    this.id = id;
    this.description = description;
    this.price = price;
    this.stock = stock;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public double getStock() {
    return stock;
  }

  public void setStock(double stock) {
    this.stock = stock;
  }

  @Override
  public String toString() {
    return "Product{" +
        "id=" + id +
        ", description='" + description + '\'' +
        ", price=" + price +
        ", stock=" + stock +
        '}';
  }
}
