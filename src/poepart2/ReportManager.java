/**
 * Author: Akani Sithole
 * Student Number: ST10503321
 * Module: PROG5121
 * POE Part 3 – VOX808
 * Description: Generates message reports and summaries.
 */
package poepart2;

import java.util.List;

public class ReportManager {

    // Method to display all messages
    public static void displayAllMessages(List<Message> messages) {
        if (messages.isEmpty()) {
            System.out.println("No messages available.");
            return;
        }

        System.out.println("--------------------------------------------------");
        System.out.println("ALL MESSAGES REPORT");
        System.out.println("--------------------------------------------------");

        for (Message msg : messages) {
            System.out.println("Message ID: " + msg.getMessageId());
            System.out.println("Sender: " + msg.getSenderPhone());
            System.out.println("Recipient: " + msg.getRecipientPhone());
            System.out.println("Content: " + msg.getContent());
            System.out.println("--------------------------------------------------");
        }

        System.out.println("Total messages: " + messages.size());
    }

    // Method to show summary counts
    public static void showSummary(int sentCount, int storedCount, int deletedCount) {
        System.out.println("--------------------------------------------------");
        System.out.println("MESSAGE SUMMARY REPORT");
        System.out.println("--------------------------------------------------");
        System.out.println("Messages Sent: " + sentCount);
        System.out.println("Messages Stored: " + storedCount);
        System.out.println("Messages Deleted: " + deletedCount);
        System.out.println("--------------------------------------------------");
    }

    // 🔍 Search messages sent to a particular recipient
    public static void searchMessagesByRecipient(List<Message> messages, String recipientPhone) {
        System.out.println("--------------------------------------------------");
        System.out.println("MESSAGES SENT TO: " + recipientPhone);
        System.out.println("--------------------------------------------------");

        boolean found = false;
        for (Message msg : messages) {
            if (msg.getRecipientPhone().equals(recipientPhone)) {
                System.out.println("Message ID: " + msg.getMessageId());
                System.out.println("Sender: " + msg.getSenderPhone());
                System.out.println("Content: " + msg.getContent());
                System.out.println("--------------------------------------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No messages found for this recipient.");
        }
    }

    // ❌ Delete message using message hash (ID)
    public static void deleteMessageById(List<Message> messages, String messageId) {
        boolean removed = messages.removeIf(msg -> msg.getMessageId().equals(messageId));

        if (removed) {
            System.out.println("Message with ID " + messageId + " deleted successfully.");
        } else {
            System.out.println("Message ID not found. No message deleted.");
        }
    }
}
