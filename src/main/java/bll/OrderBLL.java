package bll;

import dao.OrderDAO;
import model.Order;
import model.Product;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Order service (business logic layer)
 *
 * @author Daniel Reckerth
 */
public class OrderBLL {
  private final OrderDAO orderDAO;
  private final ProductBLL productBLL;

  public OrderBLL(OrderDAO orderDAO, ProductBLL productBLL) {
    this.orderDAO = orderDAO;
    this.productBLL = productBLL;
  }

  /**
   * Get all orders
   *
   * @return List of orders
   */
  public List<Order> findAllOrders() {
    final List<Order> orders = orderDAO.findAll();
    if (orders == null || orders.isEmpty()) {
      throw new NoSuchElementException("No orders found");
    }
    return orders;
  }

  /**
   * Get order by id
   *
   * @param id Order id
   * @return Order
   */
  public Order findOrderById(int id) {
    final Order order = orderDAO.findById(id);
    if (order == null) {
      throw new NoSuchElementException("Order with id " + id + " does not exist");
    }
    return order;
  }

  /**
   * Create new order
   *
   * @param order Order to create
   * @return True if order was created, false otherwise
   */
  public boolean createNewOrder(Order order) {
    try {
      Product product = productBLL.findProductById(order.getProduct_id());
      if (order.getQuantity() > product.getStock()) {
        throw new IllegalArgumentException("Not enough stock of product with id " + order.getProduct_id());
      }
      product.setStock(product.getStock() - order.getQuantity());
      productBLL.updateProduct(product.getId(), product);
      order.setTotalPrice(product.getPrice() * order.getQuantity());
      return orderDAO.save(order);
    } catch (NoSuchElementException e) {
      throw new NoSuchElementException("Product with id " + order.getProduct_id() + " does not exist");
    }

  }

  /**
   * Update order
   *
   * @param id    Order id
   * @param order Order to update
   * @return True if order was updated, false otherwise
   */
  public boolean updateOrder(int id, Order order) {
    try {
      Product product = productBLL.findProductById(order.getProduct_id());
      if (order.getQuantity() > product.getStock()) {
        throw new IllegalArgumentException("Not enough stock of product with id " + order.getProduct_id());
      }
      product.setStock(product.getStock() - order.getQuantity());
      productBLL.updateProduct(product.getId(), product);
      order.setTotalPrice(product.getPrice() * order.getQuantity());
      return orderDAO.update(id, order);
    } catch (NoSuchElementException e) {
      throw new NoSuchElementException("Product with id " + order.getProduct_id() + " does not exist");
    }
  }

  /**
   * Delete order
   *
   * @param id Order id
   * @return True if order was deleted, false otherwise
   */
  public boolean deleteOrder(int id) {
    return orderDAO.deleteById(id);
  }
}
