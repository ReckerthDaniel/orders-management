package presentation.controller.listeners;

import bll.ProductBLL;
import presentation.view.View;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class OrdersTableMouseListener implements MouseListener {
  private final View view;
  private final ProductBLL productBLL;

  public OrdersTableMouseListener(View view, ProductBLL productBLL) {
    this.view = view;
    this.productBLL = productBLL;
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    int row = view.getOrdersTable().getSelectedRow();
    if (row != -1) {
      view.setOrderInfoOfRow(row);
      view.setProductNameOrder(productBLL.findProductById(view.getProductIdOrderAtRow(row)).getDescription());
    }
  }

  @Override
  public void mousePressed(MouseEvent e) {

  }

  @Override
  public void mouseReleased(MouseEvent e) {

  }

  @Override
  public void mouseEntered(MouseEvent e) {

  }

  @Override
  public void mouseExited(MouseEvent e) {

  }
}
