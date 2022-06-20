package bll;

import dao.ProductDAO;
import model.Product;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Product service (business logic layer)
 *
 * @author Daniel Reckerth
 */
public class ProductBLL {
  private final ProductDAO productDAO;

  public ProductBLL(ProductDAO productDAO) {
    this.productDAO = productDAO;
  }

  /**
   * Get all products
   *
   * @return List of products
   */
  public List<Product> findAllProducts() {
    final List<Product> clients = productDAO.findAll();
    if (clients.isEmpty()) {
      throw new NoSuchElementException("No products found");
    }
    return clients;
  }

  /**
   * Get product by id
   *
   * @param id Product id
   * @return Product
   */
  public Product findProductById(int id) {
    final Product product = productDAO.findById(id);
    if (product == null) {
      throw new NoSuchElementException("Product with id " + id + " does not exist");
    }
    return product;
  }

  /**
   * Create new product
   *
   * @param product Product to create
   * @return True if product was created, false otherwise
   */
  public boolean createProduct(Product product) {
    return productDAO.save(product);
  }

  /**
   * Update product
   *
   * @param id      Product id
   * @param product Product to update
   * @return True if product was updated, false otherwise
   */
  public boolean updateProduct(int id, Product product) {
    return productDAO.update(id, product);
  }

  /**
   * Delete product
   *
   * @param id Product id
   * @return True if product was deleted, false otherwise
   */
  public boolean deleteProduct(int id) {
    return productDAO.deleteById(id);
  }
}
