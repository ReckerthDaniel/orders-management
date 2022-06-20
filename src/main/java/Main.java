import bll.ClientBLL;
import bll.OrderBLL;
import bll.ProductBLL;
import bll.PurchaseOrderBLL;
import dao.ClientDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import dao.PurchaseOrderDAO;
import model.Client;
import model.Order;
import model.Product;
import model.PurchaseOrder;
import presentation.controller.Controller;
import presentation.view.View;

import java.util.List;

public class Main {

  public static void main(String[] args) {
    ClientBLL clientBLL = new ClientBLL(new ClientDAO());
    ProductBLL productBLL = new ProductBLL(new ProductDAO());
    OrderBLL orderBLL = new OrderBLL(new OrderDAO(), productBLL);
    PurchaseOrderBLL purchaseOrderBLL = new PurchaseOrderBLL(new PurchaseOrderDAO());
    View view = new View();
    Controller controller = new Controller(view, clientBLL, productBLL, orderBLL, purchaseOrderBLL);

//    Order order = new Order(3, 15, 0, 2);
//    OrderBLL orderBLL = new OrderBLL(new OrderDAO(), new ProductBLL(new ProductDAO()));
//    boolean status = orderBLL.createNewOrder(order);
//    System.out.println("Status: " + status);
//    Order retrieved = orderBLL.findOrderById(3);
//    System.out.println("Retrieved: " + retrieved);
  }

  private static void getMethods() {
    ClientBLL clientBLL = new ClientBLL(new ClientDAO());
    Client client = clientBLL.findClientById(1);
    System.out.println("Find client by id 1\n" + client);

    List<Client> clients = clientBLL.findAllClients();
    System.out.println("Find all client\n" +  clients);

    ProductBLL productBLL = new ProductBLL(new ProductDAO());
    Product product = productBLL.findProductById(1);
    System.out.println("Find product by id 1\n" + product);

    List<Product> products = productBLL.findAllProducts();
    System.out.println("Find all client\n" +  products);

    OrderBLL orderBLL = new OrderBLL(new OrderDAO(), productBLL);
    Order order = orderBLL.findOrderById(1);
    System.out.println("Find order by id 1\n" + order);

    List<Order> orders = orderBLL.findAllOrders();
    System.out.println("Find all orders\n" +  orders);

    PurchaseOrderBLL purchaseOrder = new PurchaseOrderBLL(new PurchaseOrderDAO());
    PurchaseOrder purchaseOrder1 = purchaseOrder.findPurchaseOrderById(1);
    System.out.println("Find purchase order by id 1\n" + purchaseOrder1);

    List<PurchaseOrder> purchaseOrders = purchaseOrder.findAllPurchaseOrders();
    System.out.println("Find all purchase orders\n" +  purchaseOrders);
  }

  private static void insertMethods() {
//    ClientBLL clientBLL = new ClientBLL(new ClientDAO());
//    Client client = new Client(3,"Client 3", "Address 3", "0756325698");
//    boolean status = clientBLL.createClient(client);
//    System.out.println("Create client\n" + status);
//    Client retrieved = clientBLL.findClientById(3);
//    System.out.println("Find client by id 3\n" + retrieved);

//    ProductBLL productBLL = new ProductBLL(new ProductDAO());
//    Product product = new Product(3, "Pears", 1.52, 78);
//    boolean status = productBLL.createProduct(product);
//    System.out.println("Create product" + status);
//    Product retrieved = productBLL.findProductById(3);
//    System.out.println("Find product by id 3\n" + retrieved);

//    OrderBLL orderBLL = new OrderBLL(new OrderDAO());
//    Order order = new Order(3, 10, 15.2, 3);
//    boolean status = orderBLL.createOrder(order);
//    System.out.println("Create order" + status);
//    Order retrieved = orderBLL.findOrderById(3);
//    System.out.println("Find order by id 3\n" + retrieved);

//    PurchaseOrderBLL purchaseOrder = new PurchaseOrderBLL(new PurchaseOrderDAO());
//    PurchaseOrder purchaseOrder1 = new PurchaseOrder(3, LocalDate.now(), 3, 3);
//    boolean status = purchaseOrder.createPurchaseOrder(purchaseOrder1);
//    System.out.println("Create purchase order" + status);
//    PurchaseOrder retrieved = purchaseOrder.findPurchaseOrderById(3);
//    System.out.println("Find purchase order by id 3\n" + retrieved);
  }

  private static void updateMethods() {
//    ClientBLL clientBLL = new ClientBLL(new ClientDAO());
//    Client updatingClient = new Client(3,"Updated Client 3", "Address 3", "0756325698");
//    boolean status = clientBLL.updateClient(3, updatingClient);
//    System.out.println("Update client " + status);
//    Client retrieved = clientBLL.findClientById(3);
//    System.out.println("Find client by id 3\n" + retrieved);

//    ProductBLL productBLL = new ProductBLL(new ProductDAO());
//    Product updatingProduct = new Product(3, "Updated Pears", 1.52, 78);
//    boolean status = productBLL.updateProduct(3, updatingProduct);
//    System.out.println("Update product " + status);
//    Product retrieved = productBLL.findProductById(3);
//    System.out.println("Find product by id 3\n" + retrieved);

//    OrderBLL orderBLL = new OrderBLL(new OrderDAO());
//    Order updatingOrder = new Order(3, 15, 22.8, 3);
//    boolean status = orderBLL.updateOrder(3, updatingOrder);
//    System.out.println("Update order " + status);
//    Order retrieved = orderBLL.findOrderById(3);
//    System.out.println("Find order by id 3\n" + retrieved);

//    PurchaseOrderBLL purchaseOrder = new PurchaseOrderBLL(new PurchaseOrderDAO());
//    PurchaseOrder updatingPurchaseOrder = new PurchaseOrder(3, LocalDate.now().minusMonths(2), 3, 3);
//    boolean status = purchaseOrder.updatePurchaseOrder(3, updatingPurchaseOrder);
//    System.out.println("Update purchase order " + status);
//    PurchaseOrder retrieved = purchaseOrder.findPurchaseOrderById(3);
//    System.out.println("Find purchase order by id 3\n" + retrieved);
  }

  private static void deleteMethods() {
//    ClientBLL clientBLL = new ClientBLL(new ClientDAO());
//    boolean status = clientBLL.deleteClient(3);
//    System.out.println("Delete client " + status);
//    Client retrieved = clientBLL.findClientById(3);
//    System.out.println("Find client by id 3\n" + retrieved);

//    OrderBLL orderBLL = new OrderBLL(new OrderDAO());
//    boolean status = orderBLL.deleteOrder(3);
//    System.out.println("Delete order " + status);
//    Order retrieved = orderBLL.findOrderById(3);
//    System.out.println("Find order by id 3\n" + retrieved);

//    ProductBLL productBLL = new ProductBLL(new ProductDAO());
//    boolean status2 = productBLL.deleteProduct(3);
//    System.out.println("Delete product " + status2);
//    Product retrieved2 = productBLL.findProductById(3);
//    System.out.println("Find product by id 3\n" + retrieved2);

//    PurchaseOrderBLL purchaseOrder = new PurchaseOrderBLL(new PurchaseOrderDAO());
////    boolean status3 = purchaseOrder.deletePurchaseOrder(2);
////    System.out.println("Delete purchase order " + status3);
//    PurchaseOrder retrieved3 = purchaseOrder.findPurchaseOrderById(2);
//    System.out.println("Find purchase order by id 3\n" + retrieved3);
  }
}
