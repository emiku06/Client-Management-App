package Classes;

import Interfaces.Manager;
import Interfaces.Service;

import java.util.List;

public class ClientManager implements Manager {

    private Service service;
    public ClientManager(Service service) {
        this.service = service;
    }

    @Override
    public void performAction(int command, Client client, List<Client> clients) {
        switch (command){
            case 1:
                service.addClient(client, clients);
                break;
            case 2:
                service.updateClient(client.getId(), client,clients);
                break;
            case 3:
                service.removeClient(client.getId(), clients);
            default:
                 try {
                    throw new Exception("wrong command");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
        }
    }

    @Override
    public void performAction(int command, String searchItem, List<Client> clients) {
        String term ="";
        switch (command){
            case 1:
                term = "name";
                break;
            case 2:
                term = "ID";
                break;
            case 3:
                term = "department";
                break;
            default:
                try {
                    throw new Exception("wrong command");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
        }
        service.searchClients(term, searchItem,  clients);
    }
}
