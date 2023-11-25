import Classes.Client;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Objects;

public class CSVReader {
    public  static ArrayList<Client> Read(String path){
        String line;
        ArrayList<Client> clientList= new ArrayList<>();
        try (BufferedReader br =
                     new BufferedReader(new FileReader(path))) {
            br.readLine();
            while((line = br.readLine()) != null){
                String[] sLine = line.split(",");
                Client client = new Client(Integer.parseInt(sLine[0]),
                        sLine[1], sLine[2], sLine[3], Double.parseDouble(sLine[4]));
                clientList.add(client);
            }

        } catch (Exception e){
            System.out.println(e);
        }
        return clientList;
    }
}
