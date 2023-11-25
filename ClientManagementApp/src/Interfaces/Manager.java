package Interfaces;
import Classes.Client;

import java.util.List;

public interface Manager {
    void performAction(int command, Client client, List<Client> clients);
    void performAction(int command, String searchItem, List<Client> clients);
}
