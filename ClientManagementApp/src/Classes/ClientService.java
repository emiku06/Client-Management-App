package Classes;

import Interfaces.Service;

import java.util.List;
import java.util.Objects;

public class ClientService implements Service {
    /*private String readPath;
    private String writePath;
    public ClientService(String readPath, String writePath) {
        this.readPath = readPath;
        this.writePath = writePath;
    }
*/

    @Override
    public void addClient(Client client, List<Client> clients) {
        clients.add(client);
    }

    @Override
    public void updateClient(int clientId, Client updatedClient, List<Client> clients) {
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getId() == clientId) {
                clients.remove(clients.get(i));
                clients.add(updatedClient);
            }
        }
    }

    @Override
    public void removeClient(int clientId, List<Client> clients) {
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getId() == clientId) {
                clients.get(i).setActive(false);
            }
        }
    }

    @Override
    public void searchClients(String searchTerm, String searchItem, List<Client> clients) {
        switch (searchTerm){
            case "name":
                for (int i = 0; i < clients.size(); i++) {
                    if (Objects.equals(clients.get(i).getName(), searchItem)) {
                       System.out.println(clients.get(i).toString());
                    }
                }
                break;
            case "ID":
                for (int i = 0; i < clients.size(); i++) {
                    if (clients.get(i).getId() == Integer.parseInt(searchItem)) {
                        System.out.println(clients.get(i).toString());
                    }
                }
                break;
            case "department":
                for (int i = 0; i < clients.size(); i++) {
                    if (clients.get(i).getIndustry() == searchItem) {
                        System.out.println(clients.get(i).toString());
                    }
                }
                break;
        }
    }

}
