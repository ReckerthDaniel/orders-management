package bll;

import dao.ClientDAO;
import model.Client;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Client service (Business Logic Layer)
 *
 * @author Daniel Reckerth
 */
public class ClientBLL {
  private final ClientDAO clientDAO;

  public ClientBLL(ClientDAO clientDAO) {
    this.clientDAO = clientDAO;
  }

  /**
   * Find all clients
   *
   * @return List of clients
   */
  public List<Client> findAllClients() {
    final List<Client> clients = clientDAO.findAll();
    if (clients.isEmpty()) {
      throw new NoSuchElementException("No clients found");
    }
    return clients;
  }

  /**
   * Find client by id
   *
   * @param id Client id
   * @return Client with specified id
   */
  public Client findClientById(int id) {
    final Client client = clientDAO.findById(id);
    if (client == null) {
      throw new NoSuchElementException("Client with id " + id + " does not exist");
    }
    return client;
  }

  /**
   * Create new client
   *
   * @param client Client to create
   * @return True if client was created successfully, false otherwise
   */
  public boolean createClient(Client client) {
    return clientDAO.save(client);
  }

  /**
   * Update client
   *
   * @param id     Client id to update
   * @param client Updating client data
   * @return True if client was updated successfully, false otherwise
   */
  public boolean updateClient(int id, Client client) {
    return clientDAO.update(id, client);
  }

  /**
   * Delete client
   *
   * @param id Client id to delete
   * @return True if client was deleted successfully, false otherwise
   */
  public boolean deleteClient(int id) {
    return clientDAO.deleteById(id);
  }
}
