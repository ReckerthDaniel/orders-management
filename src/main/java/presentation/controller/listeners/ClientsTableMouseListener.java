package presentation.controller.listeners;

import bll.ClientBLL;
import presentation.view.View;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClientsTableMouseListener implements MouseListener {

  private final View view;
  private final ClientBLL clientBLL;

  public ClientsTableMouseListener(View view, ClientBLL clientBLL) {
    this.view = view;
    this.clientBLL = clientBLL;
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    int row = view.getClientsTable().getSelectedRow();
    if (row != -1) {
      view.setClientInfoOfRow(row);
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
