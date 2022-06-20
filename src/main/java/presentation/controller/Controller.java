package presentation.controller;

import bll.ClientBLL;
import bll.OrderBLL;
import bll.ProductBLL;
import bll.PurchaseOrderBLL;
import model.Client;
import model.Order;
import model.Product;
import model.PurchaseOrder;
import presentation.controller.listeners.ClientsTableMouseListener;
import presentation.controller.listeners.OrdersTableMouseListener;
import presentation.controller.listeners.ProductsTableMouseListener;
import presentation.controller.listeners.PurchaseTableMouseListener;
import presentation.view.View;
import utils.FileWriter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import static javax.swing.JOptionPane.*;

/**
 * Controller class
 *
 * @author Daniel Reckerth
 */
public class Controller {
  private final View view;
  private final ClientBLL clientBLL;
  private final ProductBLL productBLL;
  private final OrderBLL orderBLL;
  private final PurchaseOrderBLL purchaseOrderBLL;

  /**
   * Constructor. Also registers listeners for the view.
   *
   * @param view             View
   * @param clientBLL        Client service
   * @param productBLL       Product service
   * @param orderBLL         Order service
   * @param purchaseOrderBLL Purchase service
   */
  public Controller(View view, ClientBLL clientBLL, ProductBLL productBLL, OrderBLL orderBLL, PurchaseOrderBLL purchaseOrderBLL) {
    this.view = view;
    this.clientBLL = clientBLL;
    this.productBLL = productBLL;
    this.orderBLL = orderBLL;
    this.purchaseOrderBLL = purchaseOrderBLL;
    view.addSaveClientButtonActionListener(new AddClientButtonActionListener());
    view.addUpdateClientButtonActionListener(new UpdateClientButtonActionListener());
    view.addDeleteClientButtonActionListener(new DeleteClientButtonActionListener());
    view.addClearClientButtonActionListener(new ClearClientButtonActionListener());
    view.addClientsTableMousedActionListener(new ClientsTableMouseListener(view, clientBLL));
    view.addRefreshClientButtonActionListener(new RefreshClientButtonActionListener());
    view.addSaveProductButtonActionListener(new AddProductButtonActionListener());
    view.addUpdateProductButtonActionListener(new UpdateProductButtonActionListener());
    view.addDeleteProductButtonActionListener(new DeleteProductButtonActionListener());
    view.addClearProductButtonActionListener(new ClearProductButtonActionListener());
    view.addRefreshProductButtonActionListener(new RefreshProductButtonActionListener());
    view.addProductsTableMousedActionListener(new ProductsTableMouseListener(view, productBLL));
    view.addCreateOrderButtonActionListener(new AddOrderButtonActionListener());
    view.addUpdateOrderButtonActionListener(new UpdateOrderButtonActionListener());
    view.addDeleteOrderButtonActionListener(new DeleteOrderButtonActionListener());
    view.addClearOrderButtonActionListener(new ClearOrderButtonActionListener());
    view.addRefreshOrderButtonActionListener(new RefreshOrderButtonActionListener());
    view.addOrdersTableMousedActionListener(new OrdersTableMouseListener(view, productBLL));
    view.addCreatePurchaseButtonActionListener(new AddPurchaseButtonActionListener());
    view.addUpdatePurchaseButtonActionListener(new UpdatePurchaseButtonActionListener());
    view.addDeletePurchaseButtonActionListener(new DeletePurchaseButtonActionListener());
    view.addClearPurchaseButtonActionListener(new ClearPurchaseButtonActionListener());
    view.addRefreshPurchaseButtonActionListener(new RefreshPurchaseButtonActionListener());
    view.addPurchasesTableMousedActionListener(new PurchaseTableMouseListener(view, clientBLL));
  }

  private class AddClientButtonActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      if (view.isClientDataEmpty()) {
        view.showMessage("Please fill all fields!", WARNING_MESSAGE);
      } else {
        int id = Integer.parseInt(view.getIdClient());
        String name = view.getNameClient();
        String address = view.getAddressClient();
        String phone = view.getPhoneClient();
        Client client = new Client(id, name, address, phone);
        if (clientBLL.createClient(client)) {
          view.showMessage("Client added successfully!", INFORMATION_MESSAGE);
        } else {
          view.showMessage("Client not added!", ERROR_MESSAGE);
        }
      }
    }
  }

  private class UpdateClientButtonActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      int id = Integer.parseInt(view.getIdClient());
      String name = view.getNameClient();
      String address = view.getAddressClient();
      String phone = view.getPhoneClient();
      if (view.isClientDataEmpty()) {
        view.showMessage("Please fill all fields!", WARNING_MESSAGE);
      } else {
        Client client = new Client(id, name, address, phone);
        if (clientBLL.updateClient(id, client)) {
          view.showMessage("Client updated successfully!", INFORMATION_MESSAGE);
        } else {
          view.showMessage("Client not updated!", ERROR_MESSAGE);
        }
      }
    }
  }

  private class DeleteClientButtonActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      String id = view.getIdClient();
      if (id == null || id.isEmpty()) {
        view.showMessage("Select a client!", WARNING_MESSAGE);
      } else {
        if (clientBLL.deleteClient(Integer.parseInt(id))) {
          view.showMessage("Client deleted successfully!", INFORMATION_MESSAGE);
        } else {
          view.showMessage("Client not deleted!", ERROR_MESSAGE);
        }
      }
    }
  }

  private class ClearClientButtonActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      view.clearClientData();
    }
  }

  private class RefreshClientButtonActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      view.setClientsTable(clientBLL.findAllClients());
    }
  }

  private class AddProductButtonActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      if (view.isProductDataEmpty()) {
        view.showMessage("Please fill all fields!", WARNING_MESSAGE);
      } else {
        int id = Integer.parseInt(view.getIdProduct());
        String description = view.getDescriptionProduct();
        double price = Double.parseDouble(view.getPriceProduct());
        int stock = Integer.parseInt(view.getStockProduct());
        Product product = new Product(id, description, price, stock);
        if (productBLL.createProduct(product)) {
          view.showMessage("Product added successfully!", INFORMATION_MESSAGE);
        } else {
          view.showMessage("Product not added!", ERROR_MESSAGE);
        }
      }
    }
  }

  private class UpdateProductButtonActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      int id = Integer.parseInt(view.getIdProduct());
      String description = view.getDescriptionProduct();
      double price = Double.parseDouble(view.getPriceProduct());
      double stock = Double.parseDouble(view.getStockProduct());
      if (view.isProductDataEmpty()) {
        view.showMessage("Please fill all fields!", WARNING_MESSAGE);
      } else {
        Product product = new Product(id, description, price, stock);
        if (productBLL.updateProduct(id, product)) {
          view.showMessage("Product updated successfully!", INFORMATION_MESSAGE);
        } else {
          view.showMessage("Product not updated!", ERROR_MESSAGE);
        }
      }
    }
  }

  private class DeleteProductButtonActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      String id = view.getIdProduct();
      if (id == null || id.isEmpty()) {
        view.showMessage("Select a product!", WARNING_MESSAGE);
      } else {
        if (productBLL.deleteProduct(Integer.parseInt(id))) {
          view.showMessage("Product deleted successfully!", INFORMATION_MESSAGE);
        } else {
          view.showMessage("Product not deleted!", ERROR_MESSAGE);
        }
      }
    }
  }

  private class ClearProductButtonActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      view.clearProductData();
    }
  }

  private class RefreshProductButtonActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      view.setProductsTable(productBLL.findAllProducts());
    }
  }

  private class AddOrderButtonActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      if (view.isOrderDataEmpty()) {
        view.showMessage("Please fill all fields!", WARNING_MESSAGE);
      } else {
        int id = Integer.parseInt(view.getIdOrder());
        int productId = Integer.parseInt(view.getProductOrderId());
        int quantity = Integer.parseInt(view.getQuantity());
        Order order = new Order(id, quantity, 0, productId);
        try {
          boolean status = orderBLL.createNewOrder(order);
          if (status) {
            view.showMessage("Order added successfully!", INFORMATION_MESSAGE);
          } else {
            view.showMessage("Order not added!", ERROR_MESSAGE);
          }
        } catch (IllegalArgumentException ex) {
          view.showMessage(ex.getMessage(), WARNING_MESSAGE);
        }
      }
    }
  }

  private class UpdateOrderButtonActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      int id = Integer.parseInt(view.getIdOrder());
      int productId = Integer.parseInt(view.getIdProduct());
      int quantity = Integer.parseInt(view.getQuantity());
      Order order = new Order(id, quantity, 0, productId);
      if (view.isOrderDataEmpty()) {
        view.showMessage("Please fill all fields!", WARNING_MESSAGE);
      } else {
        if (orderBLL.updateOrder(id, order)) {
          view.showMessage("Order updated successfully!", INFORMATION_MESSAGE);
        } else {
          view.showMessage("Order not updated!", ERROR_MESSAGE);
        }
      }
    }
  }

  private class DeleteOrderButtonActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      String id = view.getIdOrder();
      if (id == null || id.isEmpty()) {
        view.showMessage("Select an order!", WARNING_MESSAGE);
      } else {
        if (orderBLL.deleteOrder(Integer.parseInt(id))) {
          view.showMessage("Order deleted successfully!", INFORMATION_MESSAGE);
        } else {
          view.showMessage("Order not deleted!", ERROR_MESSAGE);
        }
      }
    }
  }

  private class ClearOrderButtonActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      view.clearOrderData();
    }
  }

  private class RefreshOrderButtonActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      view.setOrdersTable(orderBLL.findAllOrders());
    }
  }

  private class AddPurchaseButtonActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      if (view.isPurchaseDataEmpty()) {
        view.showMessage("Please fill all fields!", WARNING_MESSAGE);
      } else {
        int id = Integer.parseInt(view.getIdPurchase());
        int clientId = Integer.parseInt(view.getClientIdPurchase());
        int orderId = Integer.parseInt(view.getOrderIdPurchase());
        PurchaseOrder purchase = new PurchaseOrder(id, LocalDate.now(), clientId, orderId);

        if (purchaseOrderBLL.createPurchaseOrder(purchase)) {
          view.showMessage("Purchase added successfully!", INFORMATION_MESSAGE);
          PurchaseOrder retrieved = purchaseOrderBLL.findPurchaseOrderById(id);
          Client client = clientBLL.findClientById(retrieved.getClient_id());
          Order order = orderBLL.findOrderById(retrieved.getOrder_id());
          Product product = productBLL.findProductById(order.getProduct_id());
          String string = "BILL NO " + id + "\n" + purchase + "\n" + client + "\n" + order + "\n" + product + "\n\n";
          FileWriter.writeToFile("BILL-" + id + ".txt", string);
        } else {
          view.showMessage("Purchase not added!", ERROR_MESSAGE);
        }

      }
    }
  }

  private class UpdatePurchaseButtonActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      int id = Integer.parseInt(view.getIdPurchase());
      int clientId = Integer.parseInt(view.getClientIdPurchase());
      int orderId = Integer.parseInt(view.getOrderIdPurchase());
      LocalDate date = LocalDate.parse(view.getPurchaseDate());
      PurchaseOrder purchase = new PurchaseOrder(id, date, clientId, orderId);
      if (view.isPurchaseDataEmpty()) {
        view.showMessage("Please fill all fields!", WARNING_MESSAGE);
      } else {
        if (purchaseOrderBLL.updatePurchaseOrder(id, purchase)) {
          view.showMessage("Purchase updated successfully!", INFORMATION_MESSAGE);
        } else {
          view.showMessage("Purchase not updated!", ERROR_MESSAGE);
        }
      }
    }
  }

  private class DeletePurchaseButtonActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      String id = view.getIdPurchase();
      if (id == null || id.isEmpty()) {
        view.showMessage("Select a purchase!", WARNING_MESSAGE);
      } else {
        if (purchaseOrderBLL.deletePurchaseOrder(Integer.parseInt(id))) {
          view.showMessage("Purchase deleted successfully!", INFORMATION_MESSAGE);
        } else {
          view.showMessage("Purchase not deleted!", ERROR_MESSAGE);
        }
      }
    }
  }

  private class ClearPurchaseButtonActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      view.clearPurchaseData();
    }
  }

  private class RefreshPurchaseButtonActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      view.setPurchasesTable(purchaseOrderBLL.findAllPurchaseOrders());
    }
  }
}
