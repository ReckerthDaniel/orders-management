package presentation.view;

import model.Client;
import model.Order;
import model.Product;
import model.PurchaseOrder;
import presentation.TableHeaders;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

/**
 * View class
 *
 * @author Daniel Reckerth
 */
public class View extends JFrame {
  private JTabbedPane tabbedPane;
  private JPanel mainPanel;
  private JPanel clientsPanel;
  private JPanel productsPanel;
  private JPanel ordersPanel;
  private JPanel purchasesPanel;
  private JTextField idClientTxtFld;
  private JTextField nameClientTxtFld;
  private JTextField addressClientTxtFld;
  private JTextField phoneClientTxtFld;
  private JButton saveClientButton;
  private JButton updateClientButton;
  private JButton deleteClientButton;
  private JButton clearClientButton;
  private JTable clientsTable;
  private JTextField idProductTxtFld;
  private JTextField descriptionProductTxtFld;
  private JTextField priceProductTxtFld;
  private JTextField stockProductTxtFld;
  private JButton saveProductButton;
  private JButton updateProductButton;
  private JButton deleteProductButton;
  private JButton refreshProductButton;
  private JTable productsTable;
  private JTextField idOrderTxtFld;
  private JTextField quantityTxtFld;
  private JTextField totalPriceTxtFld;
  private JButton updateOrderButton;
  private JButton deleteOrderButton;
  private JTextField productIdOrderTxtFld;
  private JButton createOrderButton;
  private JButton refreshOrderButton;
  private JTable ordersTable;
  private JTextField idPurchaseTxtFld;
  private JTextField purchaseDateTxtFld;
  private JButton updatePurchaseButton;
  private JButton deletePurchaseButton;
  private JTextField clientIdPurchaseTxtFld;
  private JTextField orderIdPurchaseTxtFld;
  private JButton createPurchaseButton;
  private JButton refreshPurchaseButton;
  private JTable purchaseTable;
  private JButton refreshClientButton;
  private JButton clearProductButton;
  private JButton clearOrderButton;
  private JButton clearPurchaseButton;
  private JTextField productNameOrderTxtFld;
  private JTextField clientNamePurchaseTxtFld;

  public View() {
    setContentPane(mainPanel);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    pack();
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.setVisible(true);
    init();
  }

  private void init() {
    clientNamePurchaseTxtFld.setEnabled(false);
    productNameOrderTxtFld.setEnabled(false);
    totalPriceTxtFld.setEnabled(false);
    purchaseDateTxtFld.setEnabled(false);
  }

  public void addSaveClientButtonActionListener(ActionListener listener) {
    saveClientButton.addActionListener(listener);
  }

  public void addUpdateClientButtonActionListener(ActionListener listener) {
    updateClientButton.addActionListener(listener);
  }

  public void addDeleteClientButtonActionListener(ActionListener listener) {
    deleteClientButton.addActionListener(listener);
  }

  public void addClearClientButtonActionListener(ActionListener listener) {
    clearClientButton.addActionListener(listener);
  }

  public void addRefreshClientButtonActionListener(ActionListener listener) {
    refreshClientButton.addActionListener(listener);
  }

  public void addSaveProductButtonActionListener(ActionListener listener) {
    saveProductButton.addActionListener(listener);
  }

  public void addUpdateProductButtonActionListener(ActionListener listener) {
    updateProductButton.addActionListener(listener);
  }

  public void addDeleteProductButtonActionListener(ActionListener listener) {
    deleteProductButton.addActionListener(listener);
  }

  public void addRefreshProductButtonActionListener(ActionListener listener) {
    refreshProductButton.addActionListener(listener);
  }

  public void addUpdateOrderButtonActionListener(ActionListener listener) {
    updateOrderButton.addActionListener(listener);
  }

  public void addDeleteOrderButtonActionListener(ActionListener listener) {
    deleteOrderButton.addActionListener(listener);
  }

  public void addRefreshOrderButtonActionListener(ActionListener listener) {
    refreshOrderButton.addActionListener(listener);
  }

  public void addCreateOrderButtonActionListener(ActionListener listener) {
    createOrderButton.addActionListener(listener);
  }

  public void addUpdatePurchaseButtonActionListener(ActionListener listener) {
    updatePurchaseButton.addActionListener(listener);
  }

  public void addDeletePurchaseButtonActionListener(ActionListener listener) {
    deletePurchaseButton.addActionListener(listener);
  }

  public void addCreatePurchaseButtonActionListener(ActionListener listener) {
    createPurchaseButton.addActionListener(listener);
  }

  public void addRefreshPurchaseButtonActionListener(ActionListener listener) {
    refreshPurchaseButton.addActionListener(listener);
  }

  public void addClearProductButtonActionListener(ActionListener listener) {
    clearProductButton.addActionListener(listener);
  }

  public void addClearOrderButtonActionListener(ActionListener listener) {
    clearOrderButton.addActionListener(listener);
  }

  public void addClearPurchaseButtonActionListener(ActionListener listener) {
    clearPurchaseButton.addActionListener(listener);
  }

  public void addClientsTableMousedActionListener(MouseListener listener) {
    clientsTable.addMouseListener(listener);
  }

  public void addProductsTableMousedActionListener(MouseListener listener) {
    productsTable.addMouseListener(listener);
  }

  public void addOrdersTableMousedActionListener(MouseListener listener) {
    ordersTable.addMouseListener(listener);
  }

  public void addPurchasesTableMousedActionListener(MouseListener listener) {
    purchaseTable.addMouseListener(listener);
  }

  public void showMessage(String message, int type) {
    JOptionPane.showMessageDialog(this, message, "Message", type);
  }

  public String getIdClient() {
    return idClientTxtFld.getText();
  }

  public String getNameClient() {
    return nameClientTxtFld.getText();
  }

  public String getAddressClient() {
    return addressClientTxtFld.getText();
  }

  public String getPhoneClient() {
    return phoneClientTxtFld.getText();
  }

  public String getIdProduct() {
    return idProductTxtFld.getText();
  }

  public String getDescriptionProduct() {
    return descriptionProductTxtFld.getText();
  }

  public String getPriceProduct() {
    return priceProductTxtFld.getText();
  }

  public String getStockProduct() {
    return stockProductTxtFld.getText();
  }

  public String getIdOrder() {
    return idOrderTxtFld.getText();
  }

  public String getQuantity() {
    return quantityTxtFld.getText();
  }

  public String getTotalPrice() {
    return totalPriceTxtFld.getText();
  }

  public void setProductNameOrder(String name) {
    productNameOrderTxtFld.setText(name);
  }

  public String getProductOrderId() {
    return productIdOrderTxtFld.getText();
  }

  public String getIdPurchase() {
    return idPurchaseTxtFld.getText();
  }

  public String getPurchaseDate() {
    return purchaseDateTxtFld.getText();
  }

  public String getClientIdPurchase() {
    return clientIdPurchaseTxtFld.getText();
  }

  public void setClientNamePurchase(String clientNamePurchaseTxtFld) {
    this.clientNamePurchaseTxtFld.setText(clientNamePurchaseTxtFld);
  }

  public String getOrderIdPurchase() {
    return orderIdPurchaseTxtFld.getText();
  }

  public void setIdClient(String id) {
    idClientTxtFld.setText(id);
  }

  public void setClientsTable(List<Client> clients) {
    String[] headers = TableHeaders.generateTableHeaders(clients.get(0));
    List<List<String>> data = new ArrayList<>();
    for (Client client : clients) {
      List<String> row = TableHeaders.generateTableRow(client);
      data.add(row);
    }

    String[][] arr = data.stream()
        .map(lst -> lst.toArray(String[]::new))
        .toArray(String[][]::new);

    clientsTable.setModel(new DefaultTableModel(arr, headers));
  }

  public void setProductsTable(List<Product> products) {
    String[] headers = TableHeaders.generateTableHeaders(products.get(0));
    List<List<String>> data = new ArrayList<>();
    for (Product product : products) {
      List<String> row = TableHeaders.generateTableRow(product);
      data.add(row);
    }

    String[][] arr = data.stream()
        .map(lst -> lst.toArray(String[]::new))
        .toArray(String[][]::new);

    productsTable.setModel(new DefaultTableModel(arr, headers));
  }

  public void setOrdersTable(List<Order> orders) {
    String[] headers = TableHeaders.generateTableHeaders(orders.get(0));
    List<List<String>> data = new ArrayList<>();
    for (Order order : orders) {
      List<String> row = TableHeaders.generateTableRow(order);
      data.add(row);
    }

    String[][] arr = data.stream()
        .map(lst -> lst.toArray(String[]::new))
        .toArray(String[][]::new);

    ordersTable.setModel(new DefaultTableModel(arr, headers));
  }

  public void setPurchasesTable(List<PurchaseOrder> purchases) {
    String[] headers = TableHeaders.generateTableHeaders(purchases.get(0));
    List<List<String>> data = new ArrayList<>();
    for (PurchaseOrder purchase : purchases) {
      List<String> row = TableHeaders.generateTableRow(purchase);
      data.add(row);
    }

    String[][] arr = data.stream()
        .map(lst -> lst.toArray(String[]::new))
        .toArray(String[][]::new);

    purchaseTable.setModel(new DefaultTableModel(arr, headers));
  }

  public JTable getClientsTable() {
    return clientsTable;
  }

  public JTable getProductsTable() {
    return productsTable;
  }

  public JTable getOrdersTable() {
    return ordersTable;
  }

  public JTable getPurchasesTable() {
    return purchaseTable;
  }

  public void setClientInfoOfRow(int row) {
    String id = clientsTable.getValueAt(row, 0).toString();
    String name = clientsTable.getValueAt(row, 1).toString();
    String address = clientsTable.getValueAt(row, 2).toString();
    String phone = clientsTable.getValueAt(row, 3).toString();
    idClientTxtFld.setText(id);
    idClientTxtFld.setEnabled(false);
    nameClientTxtFld.setText(name);
    addressClientTxtFld.setText(address);
    phoneClientTxtFld.setText(phone);
  }

  public void setProductInfoOfRow(int row) {
    String id = productsTable.getValueAt(row, 0).toString();
    String description = productsTable.getValueAt(row, 1).toString();
    String price = productsTable.getValueAt(row, 2).toString();
    String stock = productsTable.getValueAt(row, 3).toString();
    idProductTxtFld.setText(id);
    idProductTxtFld.setEnabled(false);
    descriptionProductTxtFld.setText(description);
    priceProductTxtFld.setText(price);
    stockProductTxtFld.setText(stock);
  }

  public void setOrderInfoOfRow(int row) {
    String id = ordersTable.getValueAt(row, 0).toString();
    String quantity = ordersTable.getValueAt(row, 1).toString();
    String totalPrice = ordersTable.getValueAt(row, 2).toString();
    String productId = ordersTable.getValueAt(row, 3).toString();
    idOrderTxtFld.setText(id);
    idOrderTxtFld.setEnabled(false);
    quantityTxtFld.setText(quantity);
    totalPriceTxtFld.setText(totalPrice);
    productIdOrderTxtFld.setText(productId);
  }

  public void setPurchaseInfoOfRow(int row) {
    String id = purchaseTable.getValueAt(row, 0).toString();
    String purchaseDate = purchaseTable.getValueAt(row, 1).toString();
    String clientId = purchaseTable.getValueAt(row, 2).toString();
    String orderId = purchaseTable.getValueAt(row, 3).toString();
    idPurchaseTxtFld.setText(id);
    idPurchaseTxtFld.setEnabled(false);
    purchaseDateTxtFld.setText(purchaseDate);
    clientIdPurchaseTxtFld.setText(clientId);
    orderIdPurchaseTxtFld.setText(orderId);
  }

  public boolean isClientDataEmpty() {
    return idClientTxtFld.getText().isEmpty() ||
        nameClientTxtFld.getText().isEmpty() ||
        addressClientTxtFld.getText().isEmpty() ||
        phoneClientTxtFld.getText().isEmpty();
  }

  public boolean isProductDataEmpty() {
    return idProductTxtFld.getText().isEmpty() ||
        descriptionProductTxtFld.getText().isEmpty() ||
        priceProductTxtFld.getText().isEmpty() ||
        stockProductTxtFld.getText().isEmpty();
  }

  public boolean isOrderDataEmpty() {
    return idOrderTxtFld.getText().isEmpty() ||
        quantityTxtFld.getText().isEmpty();
  }

  public boolean isPurchaseDataEmpty() {
    return idPurchaseTxtFld.getText().isEmpty() ||
        clientIdPurchaseTxtFld.getText().isEmpty() ||
        orderIdPurchaseTxtFld.getText().isEmpty();
  }

  public void clearClientData() {
    idClientTxtFld.setText("");
    idClientTxtFld.setEnabled(true);
    nameClientTxtFld.setText("");
    addressClientTxtFld.setText("");
    phoneClientTxtFld.setText("");
  }

  public void clearProductData() {
    idProductTxtFld.setText("");
    idProductTxtFld.setEnabled(true);
    descriptionProductTxtFld.setText("");
    priceProductTxtFld.setText("");
    stockProductTxtFld.setText("");
  }

  public void clearOrderData() {
    idOrderTxtFld.setText("");
    idOrderTxtFld.setEnabled(true);
    quantityTxtFld.setText("");
    totalPriceTxtFld.setText("");
    productIdOrderTxtFld.setText("");
    productNameOrderTxtFld.setText("");
  }

  public void clearPurchaseData() {
    idPurchaseTxtFld.setText("");
    idPurchaseTxtFld.setEnabled(true);
    purchaseDateTxtFld.setText("");
    clientIdPurchaseTxtFld.setText("");
    orderIdPurchaseTxtFld.setText("");
  }

  public int getProductIdOrderAtRow(int row) {
    return Integer.parseInt(ordersTable.getValueAt(row, 3).toString());
  }

  public int getClientIdPurchaseAtRow(int row) {
    return Integer.parseInt(purchaseTable.getValueAt(row, 2).toString());
  }
}
