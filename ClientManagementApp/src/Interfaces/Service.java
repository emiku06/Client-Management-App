package Interfaces;

import Classes.Client;

import java.util.List;

public interface Service {
    void addClient(Client client, List<Client> clients);
    void updateClient(int clientId, Client updatedClient, List<Client> clients);
    void removeClient(int clientId, List<Client> clients);
    void searchClients(String searchTerm, String searchItem, List<Client> clients);
}
