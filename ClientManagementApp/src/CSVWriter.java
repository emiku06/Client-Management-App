import Classes.Client;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class CSVWriter {
    public static void Write(Client client, String path){

        try(BufferedWriter bw =
                    new BufferedWriter(new FileWriter(path,true))) {
            String line = client.toString();
            bw.append(line).append("\n");

        }catch (Exception e){
            System.out.println(e);
        }

    }
}
