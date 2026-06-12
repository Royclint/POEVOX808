/**
 * Author: Akani Sithole
 * Student Number: ST10503321
 * Module: PROG5121
 * POE Part 2 – VOX808
 * Description: Represents a message with sender, recipient, and content.
 */
package poepart2;

import java.util.UUID; // import for unique IDs

public class Message {
    private String messageId;
    private String senderPhone;
    private String recipientPhone;
    private String content;

    // Constructor now uses UUID instead of counter
    public Message(String senderPhone, String recipientPhone, String content) {
        this.messageId = UUID.randomUUID().toString(); // generates unique ID
        this.senderPhone = senderPhone;
        this.recipientPhone = recipientPhone;
        this.content = content;
    }

    // Getters
    public String getMessageId() { return messageId; }
    public String getSenderPhone() { return senderPhone; }
    public String getRecipientPhone() { return recipientPhone; }
    public String getContent() { return content; }

    // Confirmation method
    public String sendMessage() {
        return "Message successfully sent.";
    }
}
