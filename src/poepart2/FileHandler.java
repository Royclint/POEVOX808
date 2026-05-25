/**
 * Author: Akani Sithole
 * Student Number: ST10503321
 * Module: PROG5121
 * POE Part 2 – VOX808
 * Description: Handles file operations for user data and messages.
 */
package poepart2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class FileHandler {
    private static final String USER_FILE = "userData.txt";
    private static final String MESSAGE_FILE = "messages.json";

    public void saveUser(String data) {
        try (FileWriter writer = new FileWriter(USER_FILE, true)) {
            writer.write(data + "\n");
            System.out.println("User data saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving user: " + e.getMessage());
        }
    }

    public String readLastUser() {
        String lastLine = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lastLine = line;
            }
        } catch (IOException e) {
            System.out.println("Error reading user: " + e.getMessage());
        }
        return lastLine;
    }

    public void saveMessage(Message msg) {
        try {
            JSONArray messagesArray = readMessages();

            JSONObject jsonMsg = new JSONObject();
            jsonMsg.put("MessageID", msg.getMessageId());
            jsonMsg.put("Sender", msg.getSenderPhone());
            jsonMsg.put("Recipient", msg.getRecipientPhone());
            jsonMsg.put("Message", msg.getContent());

            messagesArray.put(jsonMsg);

            try (FileWriter file = new FileWriter(MESSAGE_FILE)) {
                file.write(messagesArray.toString(4));
                file.flush();
            }

            System.out.println(msg.sendMessage());
        } catch (IOException e) {
            System.out.println("Error saving message: " + e.getMessage());
        }
    }

    public JSONArray readMessages() {
        JSONArray messagesArray = new JSONArray();
        try (FileReader reader = new FileReader(MESSAGE_FILE)) {
            JSONTokener tokener = new JSONTokener(reader);
            messagesArray = new JSONArray(tokener);
        } catch (Exception e) {
            // ignore if file doesn't exist yet
        }
        return messagesArray;
    }

    public void showMessages() {
        JSONArray messagesArray = readMessages();

        if (messagesArray.isEmpty()) {
            System.out.println("No messages found.");
        } else {
            for (int i = 0; i < messagesArray.length(); i++) {
                JSONObject msg = messagesArray.getJSONObject(i);
                System.out.println("--------------------------------------------------");
                System.out.println("Message ID: " + msg.get("MessageID"));
                System.out.println("Sender: " + msg.get("Sender"));
                System.out.println("Recipient: " + msg.get("Recipient"));
                System.out.println("Content: " + msg.get("Message"));
            }
        }
    }
}
