package bll;

import dao.PurchaseOrderDAO;
import model.PurchaseOrder;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Purchase service (business logic layer)
 *
 * @author Daniel Reckerth
 */
public class PurchaseOrderBLL {
  private final PurchaseOrderDAO purchaseOrderDAO;

  public PurchaseOrderBLL(PurchaseOrderDAO purchaseOrderDAO) {
    this.purchaseOrderDAO = purchaseOrderDAO;
  }

  /**
   * Get all purchase orders
   *
   * @return List of purchase orders
   */
  public List<PurchaseOrder> findAllPurchaseOrders() {
    final List<PurchaseOrder> purchaseOrders = purchaseOrderDAO.findAll();
    if (purchaseOrders.isEmpty()) {
      throw new NoSuchElementException("No purchase orders found");
    }
    return purchaseOrders;
  }

  /**
   * Get purchase order by id
   *
   * @param id Id of purchase order
   * @return Purchase order found
   */
  public PurchaseOrder findPurchaseOrderById(int id) {
    final PurchaseOrder purchaseOrder = purchaseOrderDAO.findById(id);
    if (purchaseOrder == null) {
      throw new NoSuchElementException("Purchase order with id " + id + " does not exist");
    }
    return purchaseOrder;
  }

  /**
   * Create purchase order
   *
   * @param purchaseOrder Purchase order to create
   * @return True if purchase order was created, false otherwise
   */
  public boolean createPurchaseOrder(PurchaseOrder purchaseOrder) {
    return purchaseOrderDAO.save(purchaseOrder);
  }

  /**
   * Update purchase order
   *
   * @param id            Id of purchase order to update
   * @param purchaseOrder Purchase order to update
   * @return True if purchase order was updated, false otherwise
   */
  public boolean updatePurchaseOrder(int id, PurchaseOrder purchaseOrder) {
    return purchaseOrderDAO.update(id, purchaseOrder);
  }

  /**
   * Delete purchase order
   *
   * @param id Id of purchase order to delete
   * @return True if purchase order was deleted, false otherwise
   */
  public boolean deletePurchaseOrder(int id) {
    return purchaseOrderDAO.deleteById(id);
  }
}
