import Classes.ClientManager;
import Classes.ClientService;
import Classes.Client;
import Interfaces.Manager;
import Interfaces.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Client> clients = new ArrayList<>();
    public static void main(String[] args) {
        String fileReader ="D:\\Emi\\Sirma\\Client Management App\\ClientManagementApp\\src\\clients.csv";
        String fileWriter ="D:\\Emi\\Sirma\\Client Management App\\ClientManagementApp\\src\\clients.csv";
        Scanner sc = new Scanner(System.in);
        clients = CSVReader.Read(fileReader);
        // dadeno
        Service service = new ClientService(/*fileReader, fileWriter*/);
        Manager manager = new ClientManager(service);
        System.out.println("Welcome to the Client Management System");
        displayOptions();
        boolean active = true;
        int command = Integer.parseInt(sc.nextLine());
        while (active) {
            switch (command){
                case 1:
                case 2:
                    String[] clientStr = sc.nextLine().split(", ");
                    Client client = new Client(Integer.parseInt(clientStr[0]), clientStr[1], clientStr[2], clientStr[3], Double.parseDouble(clientStr[4]));
                    manager.performAction(command, client, clients);
                    break;
                case 3:
                    System.out.println("Please give an ID:");
                    int id = Integer.parseInt(sc.nextLine());
                    int inRow =0;
                    for (int i = 0; i < clients.size(); i++) {
                        if (clients.get(i).getId() == id) {
                            inRow = i;
                        }
                    }
                    manager.performAction(command,clients.get(inRow), clients);
                    break;
                case 4:
                    for (int i = 0; i < clients.size(); i++) {
                        if (clients.get(i).getIsActive() == true) {
                            System.out.println(clients.get(i).toString());
                        }
                    }
                    break;
                case 5:
                    displayOptions2();
                    int cmnd = Integer.parseInt(sc.nextLine());
                    String searchItem = sc.nextLine();
                    manager.performAction(cmnd, searchItem, clients);
                    break;
                case 0:
                    for (Client c: clients
                         ) {
                       CSVWriter.Write(c, fileWriter);
                        }
                    System.exit(0);
                break;
                default:
                    System.out.println("Nonexistent command");

            }
            displayOptions();
            command = Integer.parseInt(sc.nextLine());
            // Add Client
            // 1, Oceanic Enterprises, Finance, Sarah Smith, 500000.00
            // Update Client
            // 1, Oceanic Enterprises, Tech, Sarah Smith, 750000.00
            // View Clients
            // Search Industry Tech
            // Search ID 1
            // Remove Client 1
            // Search Name Oceanic
            // Save & Exit
        }
    }

    private static void displayOptions2() {
        System.out.println("By what do you want to search?");
        System.out.println("1. Name");
        System.out.println("2. ID");
        System.out.println("3. Department");
    }

    private static void displayOptions() {
        System.out.println("Choose a number from below");
        System.out.println("1. Add");
        System.out.println("2. Update");
        System.out.println("3. Remove");
        System.out.println("4. View");
        System.out.println("5. Search ");
        System.out.println("0. Save & Exit");
    }


}