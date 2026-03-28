package poepart1;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {

    public void saveToFile(String data) {
        try {
            FileWriter writer = new FileWriter("userData.txt", true); // append mode
            writer.write(data + "\n");
            writer.close();
            System.out.println("Data saved to file.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving data.");
            e.printStackTrace();
        }
    }

    String readLastUser() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}